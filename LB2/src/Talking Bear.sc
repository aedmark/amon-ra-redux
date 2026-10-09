;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1904)
(include sci.sh)
(use Main)
(use RTRandCycle)

(public
	Talking_Bear 20
)

(instance Talking_Bear of Talker
	(properties
		sel_20 {Talking Bear}
		sel_1 100
		sel_0 0
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)
