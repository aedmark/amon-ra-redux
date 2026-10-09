;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1895)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Lo_Fat 4
)

(instance Lo_Fat of Talker
	(properties
		sel_20 {Lo Fat}
		sel_1 6
		sel_0 47
		sel_2 1895
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 100
		sel_550 -37
		name "Lo Fat"
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: loFatBust loFatEyes loFatMouth &rest)
	)
)

(instance loFatBust of Prop
	(properties
		sel_20 {loFatBust}
		sel_2 1895
		sel_3 1
	)
)

(instance loFatEyes of Prop
	(properties
		sel_20 {loFatEyes}
		sel_6 22
		sel_7 26
		sel_2 1895
		sel_3 2
	)
)

(instance loFatMouth of Prop
	(properties
		sel_20 {loFatMouth}
		sel_6 33
		sel_7 24
		sel_2 1895
	)
)
