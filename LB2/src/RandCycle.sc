;;; Sierra Script 1.0 - (do not remove this comment)
(script# 941)
(include sci.sh)
(use Main)
(use Cycle)


(class RandCycle of Cycle
	(properties
		sel_20 {RandCycle}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_467 -1
	)
	
	(method (sel_110 param1 theSel_467 theSel_143)
		(super sel_110: param1)
		(if (>= argc 2)
			(= sel_467 theSel_467)
			(if (>= argc 3) (= sel_143 theSel_143))
		else
			(= sel_467 -1)
		)
	)
	
	(method (sel_57)
		(if
		(>= (Abs (- gSel_45 sel_158)) (sel_42 sel_244?))
			(if sel_467
				(if (> sel_467 0) (-- sel_467))
				(sel_42 sel_4: (self sel_241:))
				(= sel_158 gSel_45)
			else
				(self sel_242:)
			)
		)
	)
	
	(method (sel_241 &tmp temp0)
		(return
			(if (!= (NumCels sel_42) 1)
				(while
					(==
						(= temp0 (Random 0 (sel_42 sel_246:)))
						(sel_42 sel_4?)
					)
				)
				temp0
			else
				0
			)
		)
	)
	
	(method (sel_242)
		(= sel_240 1)
		(if sel_143 (= global37 1) else (self sel_243:))
	)
)
