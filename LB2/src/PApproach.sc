;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 919)
(include sci.sh)
(use PolyPath)

(class PApproach of PolyPath
	(properties
		sel_20 {PApproach}
		sel_254 20
		sel_272 0
		sel_273 0
	)

	(method (sel_110 param1 param2 param3 param4 param5)
		(if (>= argc 1)
			(= sel_42 param1)
			(if (>= argc 2)
				(if (IsObject param2)
					(= sel_272 (param2 sel_1:))
					(= sel_273 (param2 sel_0:))
					(if (>= argc 3)
						(= sel_254 param3)
						(if (>= argc 4)
							(= sel_143 param4)
						)
					)
				else
					(= sel_272 param2)
					(= sel_273 param3)
					(if (>= argc 4)
						(= sel_254 param4)
						(if (>= argc 5)
							(= sel_143 param5)
						)
					)
				)
			)
			(super sel_110: sel_42 sel_272 sel_273 sel_143)
		else
			(super sel_110:)
		)
	)

	(method (sel_252)
		(return
			(<=
				(GetDistance (sel_42 sel_1:) (sel_42 sel_0:) sel_272 sel_273)
				sel_254
			)
		)
	)
)
