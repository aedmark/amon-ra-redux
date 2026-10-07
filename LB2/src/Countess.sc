;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1884)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Countess 29
)

(instance Countess of Talker
	(properties
		sel_20 {Countess}
		sel_1 5
		sel_0 5
		sel_2 1884
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 120
		sel_550 12
	)
	
	(method (sel_110)
		(if (proc0_2 92)
			(countessBust sel_4: 1)
			(countessEyes sel_155: 3)
			(countessMouth sel_155: 3)
		)
		(= sel_30 gSel_30)
		(super
			sel_110: countessBust countessEyes countessMouth &rest
		)
	)
)

(instance countessBust of Prop
	(properties
		sel_20 {countessBust}
		sel_2 1884
		sel_3 1
	)
)

(instance countessEyes of Prop
	(properties
		sel_20 {countessEyes}
		sel_6 35
		sel_7 42
		sel_2 1884
		sel_3 2
	)
)

(instance countessMouth of Prop
	(properties
		sel_20 {countessMouth}
		sel_6 52
		sel_7 35
		sel_2 1884
	)
)
