;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1883)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	TutSmith 9
)

(instance TutSmith of Talker
	(properties
		sel_20 {TutSmith}
		sel_1 5
		sel_0 5
		sel_2 1883
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 112
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: tutSmithBust tutSmithEyes tutSmithMouth &rest
		)
	)
)

(instance tutSmithBust of Prop
	(properties
		sel_20 {tutSmithBust}
		sel_2 1883
		sel_3 1
	)
)

(instance tutSmithEyes of Prop
	(properties
		sel_20 {tutSmithEyes}
		sel_6 44
		sel_7 30
		sel_2 1883
		sel_3 2
	)
)

(instance tutSmithMouth of Prop
	(properties
		sel_20 {tutSmithMouth}
		sel_6 65
		sel_7 20
		sel_2 1883
	)
)
