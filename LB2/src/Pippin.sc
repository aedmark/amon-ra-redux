;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1882)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Pippin 10
)

(instance Pippin of Talker
	(properties
		sel_20 {Pippin}
		sel_1 5
		sel_0 5
		sel_2 1882
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 105
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: pippinBust pippinEyes pippinMouth &rest)
	)
)

(instance pippinBust of Prop
	(properties
		sel_20 {pippinBust}
		sel_2 1882
		sel_3 1
	)
)

(instance pippinEyes of Prop
	(properties
		sel_20 {pippinEyes}
		sel_6 36
		sel_7 27
		sel_2 1882
		sel_3 2
	)
)

(instance pippinMouth of Prop
	(properties
		sel_20 {pippinMouth}
		sel_6 57
		sel_7 24
		sel_2 1882
	)
)
