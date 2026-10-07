;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1894)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Sam 3
)

(instance Sam of Talker
	(properties
		sel_20 {Sam}
		sel_1 5
		sel_0 5
		sel_2 1894
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 105
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: samBust samEyes samMouth &rest)
	)
)

(instance samBust of Prop
	(properties
		sel_20 {samBust}
		sel_2 1894
		sel_3 1
	)
)

(instance samEyes of Prop
	(properties
		sel_20 {samEyes}
		sel_6 35
		sel_7 31
		sel_2 1894
		sel_3 2
	)
)

(instance samMouth of Prop
	(properties
		sel_20 {samMouth}
		sel_6 54
		sel_7 17
		sel_2 1894
	)
)
