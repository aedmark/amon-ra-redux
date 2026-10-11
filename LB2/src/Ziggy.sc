;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1890)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Ziggy 6
)

(instance Ziggy of Talker
	(properties
		sel_20 {Ziggy}
		sel_1 5
		sel_0 5
		sel_2 1890
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 115
		sel_550 12
	)

	(method (sel_110)
		(= sel_30 gUserFont)
		(super sel_110: ziggyBust ziggyEyes ziggyMouth &rest)
	)
)

(instance ziggyBust of Prop
	(properties
		sel_20 {ziggyBust}
		sel_2 1890
		sel_3 1
	)
)

(instance ziggyEyes of Prop
	(properties
		sel_20 {ziggyEyes}
		sel_6 39
		sel_7 30
		sel_2 1890
		sel_3 2
	)
)

(instance ziggyMouth of Prop
	(properties
		sel_20 {ziggyMouth}
		sel_6 57
		sel_7 33
		sel_2 1890
	)
)
