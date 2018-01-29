; 10 probs, max 3 goals

(setq *TEST-PROBS*
    '((CC4-1 (and (surface-condition A POLISHED)
                 (painted B (WATER-RES RED)))
            ((last-time 3)
             (is-bolt (B1 (1.4 cm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (has-hole B (1.4 cm) ORIENTATION-3)
             (temperature B COLD)
             (shape B CYLINDRICAL)
             (is-object B)
             (temperature A COLD)
             (shape A CYLINDRICAL)
             (is-object A)))
     (CC4-2 (and (joined A B ORIENTATION-2)
		 (has-hole B (4 mm) ORIENTATION-2))
            ((last-time 3)
             (is-bolt (B1 (8 mm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (temperature B COLD)
	     (has-hole A (8 mm) ORIENTATION-2)
             (shape B RECTANGULAR)
             (is-object B)
             (temperature A COLD)
             (shape A RECTANGULAR)
             (is-object A)))
     (CC4-3 (and (joined A B ORIENTATION-4)
                 (shape B CYLINDRICAL))
            ((last-time 3)
             (is-bolt (B1 (4 mm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (has-hole A (4 mm) ORIENTATION-4)
             (temperature B COLD)
             (shape B RECTANGULAR)
             (is-object B)
             (temperature A COLD)
             (shape A IRREGULAR)
             (is-object A)))
     (CC4-4 (and (joined A B ORIENTATION-3)(has-hole A (2 mm) ORIENTATION-2))
            ((last-time 3)
             (is-bolt (B1 (2 mm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (painted B (REGULAR WHITE))
             (temperature B COLD)
             (shape B RECTANGULAR)
             (is-object B)
             (temperature A COLD)
             (shape A RECTANGULAR)
             (is-object A)))
     (CC4-5 (and (shape B CYLINDRICAL)
                 (painted B (WATER-RES RED))
                 (has-hole B (1.4 cm) ORIENTATION-1))
            ((last-time 3)
             (is-bolt (B1 (1 cm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (temperature B COLD)
             (shape B UNDETERMINED)
             (is-object B)
             (painted A (WATER-RES RED))
             (temperature A COLD)
             (shape A IRREGULAR)
             (is-object A)))
     (CC4-6 (and (has-hole A (2 mm) ORIENTATION-1)
                 (shape A CYLINDRICAL)
                 (surface-condition B POLISHED))
            ((last-time 3)
             (is-bolt (B1 (2 mm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (painted B (REGULAR RED))
             (temperature B COLD)
             (shape B UNDETERMINED)
             (is-object B)
             (temperature A COLD)
             (shape A UNDETERMINED)
             (is-object A)))
     (CC4-7 (and (has-hole A (1.2 cm) ORIENTATION-1)
                 (painted A (WATER-RES RED)))
            ((last-time 3)
             (is-bolt (B1 (1 cm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (painted B (REGULAR RED))
             (temperature B COLD)
             (shape B UNDETERMINED)
             (is-object B)
             (temperature A COLD)
             (shape A UNDETERMINED)
             (is-object A)))
     (CC4-8 (and (joined A B ORIENTATION-2)
	         (surface-condition B POLISHED))
            ((last-time 3)
             (is-bolt (B1 (1.2 cm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (temperature B COLD)
             (shape B RECTANGULAR)
             (is-object B)
             (surface-condition A SMOOTH)
             (temperature A COLD)
             (shape A UNDETERMINED)
             (is-object A)))
; too expensive
     (CC4-9 (and (joined A B ORIENTATION-4) (surface-condition B POLISHED))
;      (CC4-9 (and (surface-condition B POLISHED)
;		  (has-hole B (4 mm) ORIENTATION-4))
            ((last-time 3)
             (is-bolt (B1 (4 mm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (has-hole B (8 mm) ORIENTATION-2)
             (temperature B COLD)
             (shape B CYLINDRICAL)
             (is-object B)
	     (has-hole A (4 mm) ORIENTATION-4)
             (painted A (REGULAR RED))
             (surface-condition A SMOOTH)
             (temperature A COLD)
             (shape A IRREGULAR)
             (is-object A)))
     (CC4-10 (and (surface-condition A SMOOTH) (shape A CYLINDRICAL))
            ((last-time 3)
             (is-bolt (B1 (8 mm)))
             (last-scheduled B 0)
             (last-scheduled A 0)
             (temperature B COLD)
             (shape B CYLINDRICAL)
             (is-object B)
             (has-hole A (6 mm) ORIENTATION-1)
             (temperature A COLD)
             (shape A UNDETERMINED)
             (is-object A)))))