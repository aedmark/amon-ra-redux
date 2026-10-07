;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1881)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Laura 2
)

(instance Laura of Talker
	(properties
		sel_20 {Laura}
		sel_1 5
		sel_0 5
		sel_2 1881
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 107
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(lauraBust sel_156: (not (gEgo sel_584?)))
		(super sel_110: lauraBust lauraEyes lauraMouth &rest)
	)
)

(instance lauraBust of Prop
	(properties
		sel_20 {lauraBust}
		sel_2 1881
		sel_3 1
	)
)

(instance lauraEyes of Prop
	(properties
		sel_20 {lauraEyes}
		sel_6 34
		sel_7 30
		sel_2 1881
		sel_3 2
	)
)

(instance lauraMouth of Prop
	(properties
		sel_20 {lauraMouth}
		sel_6 52
		sel_7 30
		sel_2 1881
	)
)
