;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1897)
(include sci.sh)
(use Main)
(use RTRandCycle)

(public
	Sergeant 5
)

(instance Sergeant of Narrator
	(properties
		sel_20 {Sergeant}
		sel_1 10
		sel_0 70
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(= sel_540 1)
		(super sel_110: &rest)
	)
)
