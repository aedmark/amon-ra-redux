;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1893)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Ernie 23
)

(instance Ernie of Talker
	(properties
		sel_20 {Ernie}
		sel_1 5
		sel_0 5
		sel_2 1893
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 120
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: ernieBust ernieEyes ernieMouth &rest)
	)
)

(instance ernieBust of Prop
	(properties
		sel_20 {ernieBust}
		sel_2 1893
		sel_3 1
	)
)

(instance ernieEyes of Prop
	(properties
		sel_20 {ernieEyes}
		sel_6 31
		sel_7 25
		sel_2 1893
		sel_3 2
	)
)

(instance ernieMouth of Prop
	(properties
		sel_20 {ernieMouth}
		sel_6 50
		sel_7 25
		sel_2 1893
	)
)
