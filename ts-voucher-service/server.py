#coding:utf-8
import tornado.ioloop
import tornado.web
import json
import pymysql
import urllib

class GetVoucherHandler(tornado.web.RequestHandler):

    def post(self, *args, **kwargs):
        #解析传过来的数据：订单id和车型指示（0代表普通，1代表动车高铁）
        data = self.get_argument("data")
        data = json.loads(data)
        orderId = data['orderId']
        type = data['type']
        #根据订单id查询是否存在对应的凭证
        queryVoucher = self.fetchVoucherByOrderId(orderId)
        if(queryVoucher == None):
            #根据订单id请求订单的详细信息
            orderResult = self.queryOrderByIdAndType(self,orderId,type)
            order = orderResult['order']

            #往voucher表中插入报销凭证
            config = {
                'host':'ts-vouncher-mysql',
                'port':3306,
                'user':'root',
                'password':'root',
                'db':'voucherservice'
            }
            conn = pymysql.connect(**config)
            cur = conn.cursor()
            #插入语句
            sql = 'INSERT INTO voucher (order_id,travelDate,travelTime,contactName,trainNumber,seatClass,seatNumber,startStation,destStation,price)VALUES(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)'
            try:
                cur.execute(sql,(order['id'],order['travelDate'],order['travelTime'],order['contactsName'],order['trainNumber'],order['seatClass'],order['seatNumber'],order['from'],order['to'],order['price']))
                conn.commit()
            finally:
                pass
            #再次查询，可以获得刚刚插入的凭证信息
            self.write(self.fetchVoucherByOrderId(self,orderId))
        else:
            self.write(queryVoucher)

    def queryOrderByIdAndType(orderId,type):
        #普通列车
        if(type == 0):
            url='http://ts-order-other-service:12032/order/getById'
        else:
            url='http://ts-order-service:12031/order/getById'
        values ={'orderId':orderId}
        jdata = json.dumps(values)             # 对数据进行JSON格式化编码
        req = urllib.Request(url, jdata)      # 生成页面请求的完整数据
        response = urllib.urlopen(req)        # 发送页面请求
        return json.loads(response)           # 获取服务器返回的页面信息

    def fetchVoucherByOrderId(self,orderId):
        #从voucher表中查询orderId对应的报销凭证
        config = {
            'host':'ts-vouncher-mysql',
            'port':3306,
            'user':'root',
            'password':'root',
            'db':'voucherservice'
        }
        conn = pymysql.connect(**config)
        cur = conn.cursor()
        #查询语句
        sql = 'SELECT * FROM voucher where order_id = %s'
        try:
            cur.execute(sql,(orderId))
            voucher = cur.fetchone()
            conn.commit()
            return voucher
        finally:
            pass

    def get(self):
        #往voucher表中插入报销凭证
        config = {
            'host':'ts-vouncher-mysql',
            'port':3306,
            'user':'root',
            'password':'root',
            'db':'voucherservice'
        }
        conn = pymysql.connect(**config)
        cur = conn.cursor()
        #插入语句
        sql = 'INSERT INTO voucher (order_id,travelDate,travelTime,contactName,trainNumber,seatClass,seatNumber,startStation,destStation,price)VALUES(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)'
        try:
            cur.execute(sql,('1',"2017-10-18","10:58:00","lab401","D3301",1,"31","ShangHai","BeiJing",379))
            conn.commit()
        finally:
            pass

        self.write("yes")

class TestHandler(tornado.web.RequestHandler):
    def get(self):
        self.write("testing")

class Test1Handler(tornado.web.RequestHandler):
    def get(self):
        self.write("testing ------ 2")

def make_app():
    return tornado.web.Application([
        (r"/getVoucher", GetVoucherHandler),
        (r"/test", TestHandler),
        (r"/test1", Test1Handler),
    ])

def initDatabase():
    config = {
        'host':'ts-vouncher-mysql',
        'port':3306,
        'user':'root',
        'password':'root'
    }
    # 创建连接
    connect = pymysql.connect(**config)
    cur = connect.cursor()
    #创建db
    sql = "CREATE SCHEMA IF NOT EXISTS `voucherservice` ; "
    try:
        cur.execute(sql)
        connect.commit()
    finally:
        pass

    sql = "use voucherservice;CREATE TABLE if not exists `voucherservice`.`voucher` (`voucher_id` INT NOT NULL AUTO_INCREMENT,`order_id` VARCHAR(1024) NOT NULL,`travelDate` DATE NOT NULL,`travelTime` VARCHAR(1024) NOT NULL,`contactName` VARCHAR(1024) NOT NULL,`trainNumber` VARCHAR(1024) NOT NULL,`seatClass` INT NOT NULL,`seatNumber` VARCHAR(1024) NOT NULL,`startStation` VARCHAR(1024) NOT NULL,`destStation` VARCHAR(1024) NOT NULL,`price` FLOAT NOT NULL,PRIMARY KEY (`voucher_id`));"
    try:
        cur.execute(sql)
        connect.commit()
    finally:
        pass

if __name__ == "__main__":
    #创建数据库和表格
    initDatabase()
    app = make_app()
    app.listen(16101)
    tornado.ioloop.IOLoop.current().start()


    