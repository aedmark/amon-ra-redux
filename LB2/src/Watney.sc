;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1886)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Watney 11
)

(instance Watney of Talker
	(properties
		sel_20 {Watney}
		sel_1 5
		sel_0 5
		sel_2 1886
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 115
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: watneyBust watneyEyes watneyMouth &rest)
	)
)

(instance watneyBust of Prop
	(properties
		sel_20 {watneyBust}
		sel_2 1886
		sel_3 1
	)
)

(instance watneyEyes of Prop
	(properties
		sel_20 {watneyEyes}
		sel_6 36
		sel_7 30
		sel_2 1886
		sel_3 2
	)
)

(instance watneyMouth of Prop
	(properties
		sel_20 {watneyMouth}
		sel_6 54
		sel_7 29
		sel_2 1886
	)
)
