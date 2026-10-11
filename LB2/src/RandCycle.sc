;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 941)
(include sci.sh)
(use Main)
(use Motion)

(class RandCycle of Cycle
	(properties
		sel_20 {RandCycle}
		sel_467 -1
	)

	(method (sel_110 param1 param2 param3)
		(super sel_110: param1)
		(if (>= argc 2)
			(= sel_467 param2)
			(if (>= argc 3)
				(= sel_143 param3)
			)
		else
			(= sel_467 -1)
		)
	)

	(method (sel_57)
		(if (>= (Abs (- gGameTime sel_158)) (sel_42 sel_244:))
			(if sel_467
				(if (> sel_467 0)
					(-- sel_467)
				)
				(sel_42 sel_4: (self sel_241:))
				(= sel_158 gGameTime)
			else
				(self sel_242:)
			)
		)
	)

	(method (sel_241 &tmp temp0)
		(return
			(if (!= (NumCels sel_42) 1)
				(while
					(== (= temp0 (Random 0 (sel_42 sel_246:))) (sel_42 sel_4:))
				)
				temp0
			else
				0
			)
		)
	)

	(method (sel_242)
		(= sel_240 1)
		(if sel_143
			(= gDoMotionCue 1)
		else
			(self sel_243:)
		)
	)
)
