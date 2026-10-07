;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1889)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Heimlich 18
)

(instance Heimlich of Talker
	(properties
		sel_20 {Heimlich}
		sel_1 5
		sel_0 5
		sel_2 1889
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 110
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: heimlichBust heimlichEyes heimlichMouth &rest
		)
	)
)

(instance heimlichBust of Prop
	(properties
		sel_20 {heimlichBust}
		sel_2 1889
		sel_3 1
	)
)

(instance heimlichEyes of Prop
	(properties
		sel_20 {heimlichEyes}
		sel_6 36
		sel_7 28
		sel_2 1889
		sel_3 2
	)
)

(instance heimlichMouth of Prop
	(properties
		sel_20 {heimlichMouth}
		sel_6 56
		sel_7 33
		sel_2 1889
	)
)
