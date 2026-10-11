;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 939)
(include sci.sh)
(use Motion)

(class Osc of Cycle
	(properties
		sel_20 {Osc}
		sel_469 -1
	)

	(method (sel_110 param1 param2 param3)
		(if (>= argc 2)
			(= sel_469 param2)
			(if (>= argc 3)
				(= sel_143 param3)
			)
		)
		(super sel_110: param1)
	)

	(method (sel_57 &tmp temp0)
		(if (or (> (= temp0 (self sel_241:)) (sel_42 sel_246:)) (< temp0 0))
			(= sel_239 (- sel_239))
			(self sel_242:)
		else
			(sel_42 sel_4: temp0)
		)
	)

	(method (sel_242)
		(if sel_469
			(sel_42 sel_4: (self sel_241:))
			(if (> sel_469 0)
				(-- sel_469)
			)
		else
			(= sel_240 1)
			(self sel_243:)
		)
	)
)
