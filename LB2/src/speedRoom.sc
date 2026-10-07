;;; Sierra Script 1.0 - (do not remove this comment)
(script# 28)
(include sci.sh)
(use Main)
(use n958)
(use Cycle)
(use Game)
(use View)
(use Obj)

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
		(proc958_0 128 104)
		(super sel_110:)
		(gGame sel_587:)
		(gGame sel_352: 0)
		(self sel_146: speedTest)
	)
	
	(method (sel_57 &tmp temp0)
		(super sel_57:)
		(= temp0 0)
		(while (< temp0 500)
			(++ temp0)
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
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
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
			((> local0 160) (= global87 0))
			((> local0 150) (= global87 1))
			((> local0 140) (= global87 2))
			((> local0 130) (= global87 3))
			((> local0 120) (= global87 4))
			((> local0 110) (= global87 5))
			((> local0 100) (= global87 6))
			((> local0 90) (= global87 7))
			((> local0 80) (= global87 8))
			((> local0 70) (= global87 9))
			((> local0 60) (= global87 10))
			((> local0 50) (= global87 11))
			((> local0 40) (= global87 12))
			((> local0 30) (= global87 13))
			((> local0 20) (= global87 14))
			(else (= global87 15))
		)
		(gGame
			sel_321: (cond 
				((<= global87 3) 1)
				((<= global87 10) 2)
				(else 3)
			)
		)
		(gGame sel_352: 6)
		(= gSel_188 gGSel_188)
		(global2 sel_399: (if global110 29 else 105))
	)
)
