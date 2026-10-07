;;; Sierra Script 1.0 - (do not remove this comment)
(script# 790)
(include sci.sh)
(use Main)
(use LBRoom)
(use PolyPath)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm790 0
)

(instance rm790 of LBRoom
	(properties
		sel_20 {rm790}
		sel_408 790
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 790)
		(super sel_110:)
		(gSel_608 sel_40: 110 sel_3: -1 sel_99: 1 sel_39:)
		(gIconBar sel_233:)
		(gGame sel_197: 996)
		(sleeper sel_110:)
		(badGuy sel_110:)
		(self sel_146: sCartoon)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)
	
	(method (sel_57)
		(Palette palANIMATE 24 28 10)
		(super sel_57: &rest)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 2))
			(1
				(badGuy
					sel_155: 0
					sel_161: Walk
					sel_312: PolyPath 142 102 self
				)
			)
			(2
				(badGuy sel_3: 1 sel_4: 0 sel_161: End self)
			)
			(3
				(gNarrator sel_1: 120 sel_0: 140)
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(4
				(badGuy sel_3: 2 sel_4: 0 sel_161: Fwd)
				(sleeper sel_161: Fwd)
				(bullets sel_110: sel_63: 15 sel_161: End self)
				(gSel_608 sel_40: 1 sel_3: 1 sel_99: 1 sel_39:)
				(gGameMusic2 sel_40: 653 sel_3: -1 sel_99: 1 sel_39:)
			)
			(5
				(sleeper sel_161: 0)
				(badGuy sel_161: 0)
				(= sel_137 4)
				(gGameMusic2 sel_167:)
			)
			(6
				(badGuy sel_3: 3 sel_4: 0 sel_161: End self)
			)
			(7
				(badGuy
					sel_155: 4
					sel_161: Walk
					sel_312: PolyPath 0 257 self
				)
			)
			(8
				(global2 sel_399: 780)
				(self sel_111:)
			)
		)
	)
)

(instance badGuy of Actor
	(properties
		sel_20 {badGuy}
		sel_0 257
		sel_2 790
		sel_14 16384
	)
)

(instance sleeper of Prop
	(properties
		sel_20 {sleeper}
		sel_1 213
		sel_0 93
		sel_2 790
		sel_3 6
	)
)

(instance bullets of Prop
	(properties
		sel_20 {bullets}
		sel_1 184
		sel_0 29
		sel_2 790
		sel_3 5
	)
)
