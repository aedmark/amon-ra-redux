;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1900)
(include sci.sh)
(use Main)
(use RTRandCycle)
(use View)

(public
	Irmgaard 15
)

(instance Irmgaard of Talker
	(properties
		sel_20 {Irmgaard}
		sel_1 0
		sel_0 0
		sel_3 1
		sel_537 150
		sel_26 15
		sel_549 10
		sel_550 10
	)
	
	(method (sel_110)
		(= sel_2 (if (== gSel_40 155) 1156 else 828))
		(= sel_30 gSel_30)
		(if (== gSel_40 155)
			(= sel_291 0)
			(= sel_545 irmgaardBust)
			(= sel_546 irmgaardEyes)
			(= sel_547 irmgaardMouth)
			(= sel_549 10)
			(= sel_550 125)
		else
			(= sel_547 (= sel_546 (= sel_545 0)))
		)
		(super sel_110: &rest)
	)
)

(instance irmgaardBust of Prop
	(properties
		sel_20 {irmgaardBust}
		sel_2 1156
		sel_3 1
	)
)

(instance irmgaardEyes of Prop
	(properties
		sel_20 {irmgaardEyes}
		sel_6 87
		sel_7 258
		sel_2 1156
		sel_3 2
	)
)

(instance irmgaardMouth of Prop
	(properties
		sel_20 {irmgaardMouth}
		sel_6 96
		sel_7 258
		sel_2 1156
	)
)
