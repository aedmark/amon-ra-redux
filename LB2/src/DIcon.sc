;;; Sierra Script 1.0 - (do not remove this comment)
(script# 922)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Obj)


(class DIcon of Class_255_0
	(properties
		sel_20 {DIcon}
		sel_31 4
		sel_29 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_21 0
		sel_72 0
		sel_74 0
		sel_2 0
		sel_3 0
		sel_4 0
	)
	
	(method (sel_180)
		(= sel_9 (+ sel_7 (CelWide sel_2 sel_3 sel_4)))
		(= sel_8 (+ sel_6 (CelHigh sel_2 sel_3 sel_4)))
	)
)

(class DButton of Class_255_0
	(properties
		sel_20 {DButton}
		sel_31 1
		sel_29 3
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_21 0
		sel_72 0
		sel_74 0
		sel_23 0
		sel_30 0
	)
	
	(method (sel_111 param1)
		(if (and sel_23 (or (not argc) (not param1)))
			(Memory memFREE (self sel_23?))
		)
		(super sel_111:)
	)
	
	(method (sel_180 &tmp [temp0 4])
		(TextSize @[temp0 0] sel_23 sel_30 0 0)
		(= [temp0 2] (+ [temp0 2] 2))
		(= [temp0 3] (+ [temp0 3] 2))
		(= sel_8 (+ sel_6 [temp0 2]))
		(= [temp0 3] (* (/ (+ [temp0 3] 15) 16) 16))
		(= sel_9 (+ [temp0 3] sel_7))
	)
)

(class DEdit of Class_255_0
	(properties
		sel_20 {DEdit}
		sel_31 3
		sel_29 1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_21 0
		sel_72 0
		sel_74 0
		sel_23 0
		sel_30 0
		sel_34 0
		sel_33 0
	)
	
	(method (sel_179 param1)
		(EditControl self param1)
		(return self)
	)
	
	(method (sel_180 &tmp [temp0 4])
		(= sel_30 gSel_30_2)
		(TextSize @[temp0 0] {M} sel_30 0 0)
		(= sel_8 (+ sel_6 [temp0 2]))
		(= sel_9 (+ sel_7 (/ (* [temp0 3] sel_34 3) 4)))
		(= sel_33 (StrLen sel_23))
	)
)

(class DSelector of Class_255_0
	(properties
		sel_20 {DSelector}
		sel_31 6
		sel_29 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_21 0
		sel_72 0
		sel_74 0
		sel_30 0
		sel_1 20
		sel_0 6
		sel_23 0
		sel_33 0
		sel_98 0
		sel_35 0
	)
	
	(method (sel_133 param1 &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (param1 sel_73?) (return 0))
		(= temp0 0)
		(switch (param1 sel_31?)
			(4
				(param1
					sel_73:
						(switch (param1 sel_37?)
							(18176 (self sel_191: 50))
							(20224 (self sel_190: 50))
							(20736
								(self sel_190: (- sel_0 1))
							)
							(18688
								(self sel_191: (- sel_0 1))
							)
							(20480 (self sel_190: 1))
							(18432 (self sel_191: 1))
							(else  0)
						)
				)
			)
			(1
				(if (self sel_174: param1)
					(param1 sel_73: 1)
					(cond 
						((< (param1 sel_0?) (+ sel_6 10)) (repeat
							(self sel_191: 1)
							(breakif (not (proc255_0)))
						))
						((> (param1 sel_0?) (- sel_8 10)) (repeat
							(self sel_190: 1)
							(breakif (not (proc255_0)))
						))
						(else
							(TextSize @[temp5 0] {M} sel_30 0 0)
							(if
								(>
									(= temp4
										(/ (- (param1 sel_0?) (+ sel_6 10)) [temp5 2])
									)
									sel_35
								)
								(self sel_190: (- temp4 sel_35))
							else
								(self sel_191: (- sel_35 temp4))
							)
						)
					)
				)
			)
		)
		(return
			(if (and (param1 sel_73?) (& sel_29 $0002))
				self
			else
				0
			)
		)
	)
	
	(method (sel_180 &tmp [temp0 4])
		(TextSize @[temp0 0] {M} sel_30 0 0)
		(= sel_8 (+ sel_6 20 (* [temp0 2] sel_0)))
		(= sel_9 (+ sel_7 (/ (* [temp0 3] sel_1 3) 4)))
		(= sel_98 (= sel_33 sel_23))
		(= sel_35 0)
	)
	
	(method (sel_132 param1 &tmp theSel_23 temp1)
		(= theSel_23 sel_23)
		(= temp1 0)
		(return
			(while (< temp1 300)
				(if (== 0 (StrLen theSel_23)) (return -1))
				(if (not (StrCmp param1 theSel_23)) (return temp1))
				(= theSel_23 (+ theSel_23 sel_1))
				(++ temp1)
			)
		)
	)
	
	(method (sel_64 param1)
		(return (+ sel_23 (* sel_1 param1)))
	)
	
	(method (sel_190 param1 &tmp temp0)
		(if (not (StrAt sel_33 0))
			(return (not (StrAt sel_33 0)))
		)
		(= temp0 0)
		(while (and param1 (StrAt sel_33 sel_1))
			(= temp0 1)
			(= sel_33 (+ sel_33 sel_1))
			(if (< (+ sel_35 1) sel_0)
				(++ sel_35)
			else
				(= sel_98 (+ sel_98 sel_1))
			)
			(-- param1)
		)
		(return (if temp0 (self sel_80:) 1 else 0))
	)
	
	(method (sel_191 param1 &tmp temp0)
		(= temp0 0)
		(while (and param1 (!= sel_33 sel_23))
			(= temp0 1)
			(= sel_33 (- sel_33 sel_1))
			(if sel_35
				(-- sel_35)
			else
				(= sel_98 (- sel_98 sel_1))
			)
			(-- param1)
		)
		(return (if temp0 (self sel_80:) 1 else 0))
	)
)

(class Controls of List
	(properties
		sel_20 {Controls}
		sel_24 0
		sel_86 0
	)
	
	(method (sel_80)
		(self sel_119: 180)
		(self sel_119: 80)
	)
	
	(method (sel_133 param1 &tmp temp0)
		(if (param1 sel_73?) (return 0))
		(if
			(and
				(= temp0 (self sel_120: 133 param1))
				(not (temp0 sel_185: 2))
			)
			(temp0 sel_57:)
			(= temp0 0)
		)
		(return temp0)
	)
)
