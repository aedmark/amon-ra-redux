;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 785)
(include sci.sh)
(use Main)
(use eRS)
(use Actor)
(use System)

(public
	rm785 0
)

(local
	local0
	local1
	local2
	[local3 19] = [342 597 850 1113 1366 1628 1885 2131 2394 2651 2900 3166 3424 3683 3937 4184 4439 4688 4962]
)

(instance rm785 of LBRoom
	(properties
		sel_20 {rm785}
		sel_408 780
	)

	(method (sel_110)
		(super sel_110:)
		(gGameMusic1 sel_40: 140 sel_99: 1 sel_3: -1 sel_39:)
		(= local0
			(switch global126
				(1 1)
				(2 2)
				(3 3)
				(4 4)
			)
		)
		(gTheIconBar sel_233:)
		(gGame sel_197: 996)
		(= local1 (>> (& [local3 local2] $ff00) $0008))
		(characterView
			sel_2: (+ 1800 (& [local3 local2] $00ff))
			sel_3: 1
			sel_1: 10
			sel_0: 10
			sel_110:
		)
		(gNarrator sel_1: 10 sel_0: 113 sel_537: 290)
		(self sel_146: sCartoon)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)

	(method (sel_144 param1 &tmp [temp0 100])
		(switch (= sel_29 param1)
			(0
				(gCurRoom
					sel_417:
						(if (== (characterView sel_2:) 1898) 785 else 780)
						10
				)
				(= sel_136 2)
			)
			(1
				(gMessager sel_295: local1 0 local0 0 self)
			)
			(2
				(++ local2)
				(characterView sel_111:)
				(= sel_139 120)
			)
			(3
				(if (== local2 19)
					(gGameMusic1 sel_170: 0 12 30 1)
					(gCurRoom
						sel_399: (if (OneOf global126 1 4) 780 else 790)
					)
				else
					(= local1 (>> (& [local3 local2] $ff00) $0008))
					(characterView
						sel_2: (+ 1800 (& [local3 local2] $00ff))
						sel_3: 1
						sel_1:
							(switch (mod local1 3)
								(0 220)
								(1 10)
								(2 115)
							)
						sel_0:
							(cond
								((== local1 19) 5)
								((and (< (mod local1 6) 4) (> (mod local1 6) 0)) 10)
								(else 103)
							)
						sel_110:
					)
					(gNarrator
						sel_1: (if (== local1 19) 160 else 10)
						sel_0: (if (== (characterView sel_0:) 10) 113 else 10)
						sel_537: (if (== local1 19) 140 else 290)
					)
					(self sel_144: 0)
				)
			)
		)
	)
)

(instance characterView of View
	(properties
		sel_20 {characterView}
	)
)
