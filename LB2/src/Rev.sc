;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 969)
(include sci.sh)
(use Motion)

(class Rev of Cycle
	(properties
		sel_20 {Rev}
		sel_239 -1
	)

	(method (sel_57 &tmp temp0)
		(if (< (= temp0 (self sel_241:)) 0)
			(self sel_242:)
		else
			(sel_42 sel_4: temp0)
		)
	)

	(method (sel_242)
		(sel_42 sel_4: (sel_42 sel_246:))
	)
)
