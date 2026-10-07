;;; Sierra Script 1.0 - (do not remove this comment)
(script# 23)
(include sci.sh)
(use Main)
(use PolyPath)
(use Obj)


(class ExitFeature of Obj
	(properties
		sel_20 {ExitFeature}
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_33 999
		sel_582 -1
		sel_583 0
		sel_213 0
	)
	
	(method (sel_110)
		(gLb2Exits sel_118: self)
		(= sel_33 ((Cursor sel_109:) sel_2: sel_33))
	)
	
	(method (sel_57)
		(cond 
			((self sel_218: gSel_1 (- gSel_0 10))
				(if (== sel_582 -1)
					(= sel_582 gSel_582)
					(gGame sel_197: sel_33)
				)
			)
			((!= sel_582 -1)
				(if (== gSel_582 sel_33)
					(gGame sel_197: ((gIconBar sel_228?) sel_33?))
				)
				(= sel_582 -1)
			)
		)
	)
	
	(method (sel_111 &tmp theSel_33)
		(if (IsObject sel_33)
			(= sel_33 ((= theSel_33 sel_33) sel_2?))
			(theSel_33 sel_111:)
		)
		(gLb2Exits sel_81: self)
	)
	
	(method (sel_218 param1 param2)
		(return
			(if
				(and
					(<= sel_7 param1)
					(<= param1 sel_9)
					(<= sel_6 param2)
				)
				(<= param2 sel_8)
			else
				0
			)
		)
	)
	
	(method (sel_133 param1)
		(cond 
			((not (gUser sel_342?)))
			((not (self sel_218: gSel_1 (- gSel_0 10))))
			(
				(or
					(and (== (param1 sel_31?) 4) (!= (param1 sel_37?) 13))
					(and (== (param1 sel_31?) 1) (param1 sel_61?))
					(not (proc999_5 (param1 sel_31?) 1 4))
				)
				(= sel_582 -1)
			)
			((== gSel_582 ((gIconBar sel_64: 1) sel_33?)) (param1 sel_73: 1) (gLb2Messager sel_295: sel_213 1))
			((!= gSel_582 sel_33))
			(else
				(param1 sel_73: 1)
				(switch sel_583
					(1
						(gEgo sel_312: PolyPath gSel_1 0)
					)
					(3
						(gEgo sel_312: PolyPath gSel_1 190)
					)
					(2
						(gEgo sel_312: PolyPath 320 (- gSel_0 10))
					)
					(4
						(gEgo sel_312: PolyPath 0 (- gSel_0 10))
					)
				)
			)
		)
	)
)
