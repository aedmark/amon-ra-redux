;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1888)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	O_Riley 19
)

(instance O_Riley of Talker
	(properties
		sel_20 {O'Riley}
		sel_1 5
		sel_0 5
		sel_2 1888
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 115
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: oRileyBust oRileyEyes oRileyMouth &rest)
	)
)

(instance oRileyBust of Prop
	(properties
		sel_20 {oRileyBust}
		sel_2 1888
		sel_3 1
	)
)

(instance oRileyEyes of Prop
	(properties
		sel_20 {oRileyEyes}
		sel_6 38
		sel_7 31
		sel_2 1888
		sel_3 2
	)
)

(instance oRileyMouth of Prop
	(properties
		sel_20 {oRileyMouth}
		sel_6 57
		sel_7 30
		sel_2 1888
	)
)
