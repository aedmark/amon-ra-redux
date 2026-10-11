;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1887)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Steve 12
)

(instance Steve of Talker
	(properties
		sel_20 {Steve}
		sel_1 5
		sel_0 5
		sel_2 1887
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 107
		sel_550 12
	)

	(method (sel_110)
		(= sel_30 gUserFont)
		(super sel_110: steveBust steveEyes steveMouth &rest)
	)
)

(instance steveBust of Prop
	(properties
		sel_20 {steveBust}
		sel_2 1887
		sel_3 1
	)
)

(instance steveEyes of Prop
	(properties
		sel_20 {steveEyes}
		sel_6 39
		sel_7 27
		sel_2 1887
		sel_3 2
	)
)

(instance steveMouth of Prop
	(properties
		sel_20 {steveMouth}
		sel_6 58
		sel_7 32
		sel_2 1887
	)
)
