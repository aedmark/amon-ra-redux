;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	speedRoom 0
)

(local
	local0
	local1
)

(instance speedRoom of Rm
	(properties
		sel_20 {speedRoom}
		sel_408 780
	)

	(method (sel_110)
		(LoadMany rsVIEW 104)
		(super sel_110:)
		(gGame sel_587:)
		(gGame sel_352: 0)
		(self sel_146: speedTest)
	)

	(method (sel_57 &tmp temp0)
		(super sel_57:)
		(for ((= temp0 0)) (< temp0 500) ((++ temp0))
		)
	)
)

(instance fred of Actor
	(properties
		sel_20 {fred}
		sel_2 104
	)
)

(instance speedTest of Script
	(properties
		sel_20 {speedTest}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(fred
					sel_155: 0
					sel_15: 0
					sel_153: 0 0
					sel_338: 1 1
					sel_161: Fwd
					sel_110:
				)
				(= sel_136 1)
			)
			(1
				(= local1 (GetTime))
				(fred sel_312: MoveTo 320 190)
				(= sel_136 50)
			)
			(2
				(= local0 (- (GetTime) local1))
				(startGame sel_57:)
			)
		)
	)
)

(instance startGame of Code
	(properties
		sel_20 {startGame}
	)

	(method (sel_57 &tmp [temp0 100])
		(cond
			((> local0 160)
				(= gHowFast 0)
			)
			((> local0 150)
				(= gHowFast 1)
			)
			((> local0 140)
				(= gHowFast 2)
			)
			((> local0 130)
				(= gHowFast 3)
			)
			((> local0 120)
				(= gHowFast 4)
			)
			((> local0 110)
				(= gHowFast 5)
			)
			((> local0 100)
				(= gHowFast 6)
			)
			((> local0 90)
				(= gHowFast 7)
			)
			((> local0 80)
				(= gHowFast 8)
			)
			((> local0 70)
				(= gHowFast 9)
			)
			((> local0 60)
				(= gHowFast 10)
			)
			((> local0 50)
				(= gHowFast 11)
			)
			((> local0 40)
				(= gHowFast 12)
			)
			((> local0 30)
				(= gHowFast 13)
			)
			((> local0 20)
				(= gHowFast 14)
			)
			(else
				(= gHowFast 15)
			)
		)
		(gGame
			sel_321:
				(cond
					((<= gHowFast 3) 1)
					((<= gHowFast 10) 2)
					(else 3)
				)
		)
		(gGame sel_352: 6)
		(= gEatMice global18)
		(gCurRoom sel_399: (if global110 29 else 105))
	)
)
