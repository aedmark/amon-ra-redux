;;; Sierra Script 1.0 - (do not remove this comment)
(script# 934)
(include sci.sh)
(use IconI)
(use Obj)


(class Slider of IconI
	(properties
		sel_20 {Slider}
		sel_2 -1
		sel_3 -1
		sel_4 -1
		sel_7 0
		sel_6 -1
		sel_9 0
		sel_8 0
		sel_29 0
		sel_33 -1
		sel_31 16384
		sel_37 -1
		sel_61 0
		sel_14 1
		sel_208 0
		sel_209 0
		sel_210 0
		sel_211 0
		sel_212 0
		sel_213 0
		sel_214 0
		sel_215 0
		sel_511 0
		sel_512 0
		sel_513 0
		sel_514 0
		sel_515 0
		sel_516 0
		sel_517 0
		sel_518 0
		sel_5 0
		sel_52 1
		sel_348 0
		sel_519 0
		sel_520 0
		sel_521 0
	)
	
	(method (sel_57)
		(if sel_348 (proc999_7 sel_348 sel_519 &rest))
	)
	
	(method (sel_216)
		(super sel_216: &rest)
		(if (not sel_516)
			(= sel_515 sel_7)
			(= sel_516 sel_9)
			(= sel_517 (- sel_8 (CelHigh sel_511 sel_512 sel_513)))
			(= sel_518 sel_6)
		)
		(= sel_514 (self sel_522:))
		(DrawCel sel_511 sel_512 sel_513 sel_515 sel_514 -1)
		(Graph
			grUPDATE_BOX
			(- sel_6 1)
			(- sel_7 1)
			(+ 2 sel_8)
			(+ 2 sel_9)
			1
		)
	)
	
	(method (sel_178 param1 &tmp eventSel_109)
		(return
			(if (and argc param1)
				(while
				(!= ((= eventSel_109 (Event sel_109:)) sel_31?) 2)
					(eventSel_109 sel_148:)
					(cond 
						((< (eventSel_109 sel_0?) (- sel_514 sel_52)) (self sel_181: sel_52 (not (& sel_14 $0200))))
						((> (eventSel_109 sel_0?) (+ sel_514 sel_52)) (self sel_181: (- sel_52) (not (& sel_14 $0200))))
					)
					(eventSel_109 sel_111:)
				)
				(if (& sel_14 $0200)
					(self sel_57: (self sel_523: sel_514))
				)
				(eventSel_109 sel_111:)
			else
				(return 1)
			)
		)
	)
	
	(method (sel_217)
	)
	
	(method (sel_190)
		(self
			sel_181:
				(proc999_3
					sel_52
					(-
						sel_514
						(self
							sel_522: (+ (self sel_57:) (proc999_0 (- sel_521 sel_520)))
						)
					)
				)
				(not (& sel_14 $0200))
		)
		(if (& sel_14 $0200)
			(self sel_57: (self sel_523: sel_514))
		)
	)
	
	(method (sel_191)
		(self
			sel_181:
				(proc999_2
					(- sel_52)
					(-
						sel_514
						(self
							sel_522: (- (self sel_57:) (proc999_0 (- sel_521 sel_520)))
						)
					)
				)
				(not (& sel_14 $0200))
		)
		(if (& sel_14 $0200)
			(self sel_57: (self sel_523: sel_514))
		)
	)
	
	(method (sel_181 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp7 (if (not argc) else param2))
		(= temp5 (proc999_0 param1))
		(= temp4 param1)
		(while (<= sel_52 (Abs temp4))
			(= temp0 (- sel_514 (* temp5 sel_52)))
			(= temp1 (CelHigh sel_511 sel_512 sel_513))
			(= sel_514
				(cond 
					((< temp0 sel_518) sel_518)
					((> temp0 sel_517) sel_517)
					(else temp0)
				)
			)
			(= temp2 (PicNotValid))
			(PicNotValid 1)
			(DrawCel sel_2 sel_3 sel_4 sel_7 sel_6 -1)
			(DrawCel sel_511 sel_512 sel_513 sel_515 sel_514 -1)
			(Graph
				grUPDATE_BOX
				(- sel_6 1)
				(- sel_7 1)
				(+ 2 sel_8)
				(+ 2 sel_9)
				1
			)
			(PicNotValid temp2)
			(= temp3 (self sel_523: sel_514))
			(= temp6
				(if temp7 (self sel_57: temp3) else (self sel_57:))
			)
			(= temp4 (- temp4 (* sel_52 temp5)))
		)
		(return temp6)
	)
	
	(method (sel_522 param1 &tmp temp0)
		(return
			(cond 
				(
					(and
						(<
							(= temp0 (if argc param1 else (self sel_57:)))
							sel_521
						)
						(< temp0 sel_520)
					)
					(if (< sel_520 sel_521) sel_517 else sel_518)
				)
				((and (> temp0 sel_521) (> temp0 sel_520)) (if (< sel_520 sel_521) sel_518 else sel_517))
				(else
					(+
						sel_518
						(/
							(* (Abs (- sel_521 temp0)) (- sel_517 sel_518))
							(Abs (- sel_521 sel_520))
						)
					)
				)
			)
		)
	)
	
	(method (sel_523 param1)
		(return
			(+
				sel_520
				(/
					(* (- sel_517 param1) (- sel_521 sel_520))
					(- sel_517 sel_518)
				)
			)
		)
	)
)
