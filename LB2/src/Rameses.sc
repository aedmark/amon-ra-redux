;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1891)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Rameses 27
)

(instance Rameses of Talker
	(properties
		sel_20 {Rameses}
		sel_1 5
		sel_0 5
		sel_2 1891
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 110
		sel_550 12
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super
			sel_110: ramesesBust ramesesEyes ramesesMouth &rest
		)
	)
)

(instance ramesesBust of Prop
	(properties
		sel_20 {ramesesBust}
		sel_2 1891
		sel_3 1
	)
)

(instance ramesesEyes of Prop
	(properties
		sel_20 {ramesesEyes}
		sel_6 39
		sel_7 36
		sel_2 1891
		sel_3 2
	)
)

(instance ramesesMouth of Prop
	(properties
		sel_20 {ramesesMouth}
		sel_6 54
		sel_7 27
		sel_2 1891
	)
)
