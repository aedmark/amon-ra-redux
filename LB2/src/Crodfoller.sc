;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1896)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Crodfoller 7
)

(instance Crodfoller of Talker
	(properties
		sel_20 {Crodfoller}
		sel_1 220
		sel_0 15
		sel_2 1896
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 -200
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: crodfollerBust crodfollerEyes crodfollerMouth &rest
		)
	)
)

(instance crodfollerBust of Prop
	(properties
		sel_20 {crodfollerBust}
		sel_2 1896
		sel_3 1
	)
)

(instance crodfollerEyes of Prop
	(properties
		sel_20 {crodfollerEyes}
		sel_6 31
		sel_7 33
		sel_2 1896
		sel_3 2
	)
)

(instance crodfollerMouth of Prop
	(properties
		sel_20 {crodfollerMouth}
		sel_6 50
		sel_7 27
		sel_2 1896
	)
)
