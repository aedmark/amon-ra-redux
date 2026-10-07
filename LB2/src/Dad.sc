;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1880)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Dad 1
)

(instance Dad of Talker
	(properties
		sel_20 {Dad}
		sel_1 5
		sel_0 5
		sel_2 1880
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 105
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: dadBust dadEyes dadMouth &rest)
	)
)

(instance dadBust of Prop
	(properties
		sel_20 {dadBust}
		sel_2 1880
		sel_3 1
	)
)

(instance dadEyes of Prop
	(properties
		sel_20 {dadEyes}
		sel_6 34
		sel_7 26
		sel_2 1880
		sel_3 2
	)
)

(instance dadMouth of Prop
	(properties
		sel_20 {dadMouth}
		sel_6 56
		sel_7 22
		sel_2 1880
	)
)
