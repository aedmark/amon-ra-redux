;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1899)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Coroner 21
)

(instance Coroner of Talker
	(properties
		sel_20 {Coroner}
		sel_1 100
		sel_0 0
		sel_6 5
		sel_7 5
		sel_2 1899
		sel_3 3
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: coronerBust coronerEyes coronerMouth &rest
		)
	)
)

(instance coronerBust of Prop
	(properties
		sel_20 {coronerBust}
		sel_2 1899
		sel_3 1
	)
)

(instance coronerEyes of Prop
	(properties
		sel_20 {coronerEyes}
		sel_6 15
		sel_7 30
		sel_2 1899
		sel_3 2
	)
)

(instance coronerMouth of Prop
	(properties
		sel_20 {coronerMouth}
		sel_6 33
		sel_7 30
		sel_2 1899
	)
)
