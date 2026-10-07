;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1885)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Yvette 28
)

(instance Yvette of Talker
	(properties
		sel_20 {Yvette}
		sel_1 5
		sel_0 5
		sel_2 1885
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 110
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: yvetteBust yvetteEyes yvetteMouth &rest)
	)
)

(instance yvetteBust of Prop
	(properties
		sel_20 {yvetteBust}
		sel_2 1885
		sel_3 1
	)
)

(instance yvetteEyes of Prop
	(properties
		sel_20 {yvetteEyes}
		sel_6 29
		sel_7 21
		sel_2 1885
		sel_3 2
	)
)

(instance yvetteMouth of Prop
	(properties
		sel_20 {yvetteMouth}
		sel_6 47
		sel_7 25
		sel_2 1885
	)
)
