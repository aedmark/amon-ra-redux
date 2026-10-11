;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 956)
(include sci.sh)
(use Motion)

(class ForwardCounter of Fwd
	(properties
		sel_20 {ForwardCounter}
		sel_467 0
	)

	(method (sel_110 param1 param2 param3)
		(super sel_110: param1)
		(if (>= argc 2)
			(= sel_467 param2)
			(if (>= argc 3)
				(= sel_143 param3)
			)
		)
	)

	(method (sel_242)
		(if (-- sel_467)
			(super sel_242:)
		else
			(= sel_240 1)
			(self sel_243:)
		)
	)
)
