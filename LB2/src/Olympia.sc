;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1892)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Olympia 25
)

(instance Olympia of Talker
	(properties
		sel_20 {Olympia}
		sel_1 5
		sel_0 5
		sel_2 1892
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 112
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: olympiaBust olympiaEyes olympiaMouth &rest
		)
	)
)

(instance olympiaBust of Prop
	(properties
		sel_20 {olympiaBust}
		sel_2 1892
		sel_3 1
	)
)

(instance olympiaEyes of Prop
	(properties
		sel_20 {olympiaEyes}
		sel_6 39
		sel_7 31
		sel_2 1892
		sel_3 2
	)
)

(instance olympiaMouth of Prop
	(properties
		sel_20 {olympiaMouth}
		sel_6 59
		sel_7 26
		sel_2 1892
	)
)
