;;; Sierra Script 1.0 - (do not remove this comment)
(script# 780)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use n958)
(use Sound)
(use Jump)
(use Cycle)
(use View)
(use Obj)

(public
	rm780 0
)

(local
	local0
	local1
	local2
	[local3 9]
	local12
)
(procedure (localproc_0044)
	(= local2 0)
	(= local1 0)
	(while (< local1 (creditTitle sel_246:))
		(= [local3 local1] (creditName sel_2: 791 sel_109:))
		([local3 local1] sel_155: local0 sel_156: (+ local1 1))
		(++ local2)
		(++ local1)
	)
)

(procedure (localproc_0089)
	(= local2 0)
	(= local1 0)
	(while (< local1 (creditTitle sel_246:))
		(= [local3 local1] (creditName sel_2: 8000 sel_109:))
		([local3 local1] sel_155: local0 sel_156: (+ local1 1))
		(++ local2)
		(++ local1)
	)
)

(instance rm780 of LBRoom
	(properties
		sel_20 {rm780}
		sel_408 780
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 792 791)
		(proc958_0 132 795)
		(super sel_110:)
		(wrapMusic
			sel_110: 1 795 1312 (if (== global106 32) 310 else 314) 311
		)
		(gGame sel_587:)
		(gIconBar sel_233:)
		(gGame sel_197: 996 1)
		(if (== (gGame sel_84?) 1)
			(self sel_146: runCredits)
		else
			(self sel_146: runCreditsFor)
		)
	)
)

(instance runCredits of Script
	(properties
		sel_20 {runCredits}
	)
	
	(method (sel_144 theSel_29 &tmp [temp0 100])
		(switch (= sel_29 theSel_29)
			(0
				(creditTitle sel_2: 791 sel_155: local0 sel_110: sel_317:)
				(localproc_0044)
				(creditProp sel_110: sel_216: sel_4: 0 sel_161: 0)
				(switch local0
					(0
						(creditProp sel_155: 0 sel_1: 57 sel_0: 146)
					)
					(1
						(creditProp sel_155: 1 sel_1: 42 sel_0: 109)
					)
					(2
						(creditProp sel_155: 2 sel_1: -20 sel_0: 189 sel_313:)
					)
					(3
						(creditProp sel_155: 2 sel_1: -20 sel_0: 189 sel_313:)
					)
					(4
						(creditProp sel_155: 9 sel_1: 20 sel_0: 160)
					)
					(5
						(creditProp sel_155: 6 sel_1: 270 sel_0: 170)
					)
					(6
						(creditProp sel_155: 3 sel_1: -20 sel_0: 189)
					)
					(7
						(creditProp sel_155: 4 sel_1: 339 sel_0: 189)
					)
					(8
						(creditProp sel_155: 5 sel_1: 339 sel_0: 189)
					)
					(9
						(creditProp sel_155: 7 sel_1: 46 sel_0: 175)
					)
					(10
						(creditProp sel_155: 7 sel_1: 46 sel_0: 175)
					)
					(11
						(creditProp sel_155: 10 sel_1: 46 sel_0: 175)
					)
					(12
						(creditProp sel_155: 11 sel_1: 46 sel_0: 175)
					)
				)
				(if (== (creditProp sel_3?) 7)
					(volleyBall sel_110: sel_1: 43 sel_0: 124 sel_102:)
					(sunnyTwo sel_110: sel_216:)
				else
					(volleyBall sel_111:)
					(sunnyTwo sel_111:)
				)
				(= sel_136 1)
			)
			(1
				(= local12
					(if (proc999_5 local0 5 6 7 8 9 11 12) 90 else 40)
				)
				(= local1 0)
				([local3 local1] sel_110:)
				(= sel_136 1)
			)
			(2
				([local3 local1] sel_312: MoveTo 86 local12 self)
				(if (< (+ local1 1) local2)
					([local3 (+ local1 1)] sel_110:)
				)
				(= sel_136 1)
			)
			(3
				(if (>= (+ local1 1) local2) (= sel_29 4) else 0)
			)
			(4
				([local3 local1] sel_317:)
				(++ local1)
				(if (== local0 6)
					(= local12 (+ local12 40))
				else
					(= local12
						(switch local0
							(12 150)
							(11 150)
							(else 
								(+ (/ 164 local2) local12)
							)
						)
					)
				)
				(= sel_29 1)
				(self sel_145:)
			)
			(5
				(switch local0
					(0
						(creditProp sel_161: End)
						(= sel_139 300)
					)
					(1
						(creditProp sel_161: End)
						(= sel_139 300)
					)
					(2 (= sel_139 300))
					(3
						(creditProp sel_161: End)
						(= sel_139 300)
					)
					(4
						(creditProp sel_161: End)
						(= sel_139 300)
					)
					(5
						(creditProp sel_161: End)
						(= sel_139 300)
					)
					(6
						(creditProp sel_161: Fwd sel_312: MoveTo 75 189 self)
					)
					(7
						(creditProp sel_161: Fwd sel_312: MoveTo 235 189 self)
					)
					(8
						(creditProp sel_161: Fwd sel_312: MoveTo 235 189 self)
					)
					(9
						(creditProp sel_146: sPlay self)
					)
					(10
						(creditProp sel_146: sPlay self)
					)
					(11
						(creditProp sel_161: End)
						(= sel_139 300)
					)
					(12
						(creditProp sel_161: End)
						(= sel_139 300)
					)
				)
			)
			(6
				(creditProp sel_111:)
				(global2 sel_417: 780)
				(gSel_561 sel_119: 111)
				(if (< local0 12)
					(++ local0)
					(self sel_144: -1)
					(= sel_136 1)
				else
					(= sel_137 4)
				)
			)
			(7
				(global2 sel_422: daggerInset self)
			)
			(8
				(creditSound sel_170: 0 30 12 1)
				(= sel_137 3)
			)
			(9 (= global4 1))
		)
	)
)

(instance runCreditsFor of Script
	(properties
		sel_20 {runCreditsFor}
	)
	
	(method (sel_144 theSel_29 &tmp [temp0 100])
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_197: 996 1)
				(creditTitle
					sel_2: 8000
					sel_155: local0
					sel_110:
					sel_317:
				)
				(localproc_0089)
				(= sel_136 1)
			)
			(1
				(= local12 85)
				(= local1 0)
				([local3 local1] sel_110:)
				(= sel_136 1)
			)
			(2
				([local3 local1] sel_312: MoveTo 86 local12 self)
				(if (< (+ local1 1) local2)
					([local3 (+ local1 1)] sel_110:)
				)
				(= sel_136 1)
			)
			(3
				(if (>= (+ local1 1) local2) (= sel_29 4) else 0)
			)
			(4
				([local3 local1] sel_317:)
				(++ local1)
				(= local12 (+ local12 30))
				(= sel_29 1)
				(self sel_145:)
			)
			(5 (= sel_137 5))
			(6
				(global2 sel_417: 780)
				(gSel_561 sel_119: 111)
				(if (< local0 3)
					(++ local0)
					(self sel_144: -1)
					(= sel_136 1)
				else
					(= sel_136 1)
				)
			)
			(7
				(= local0 0)
				(gGame sel_197: 996 1)
				(self sel_146: runCredits)
			)
		)
	)
)

(instance sPlay of Script
	(properties
		sel_20 {sPlay}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(volleyBall sel_216: sel_161: Fwd)
				(creditProp sel_161: End self)
				(volleyBall sel_312: JumpTo 283 125 self)
			)
			(1 0)
			(2
				(sunnyTwo sel_161: End self)
				(volleyBall sel_312: JumpTo 43 124 self)
			)
			(3 0)
			(4
				(creditProp sel_161: End self)
				(volleyBall sel_312: JumpTo 283 125 self)
			)
			(5 0)
			(6
				(sunnyTwo sel_161: End self)
				(volleyBall sel_111:)
			)
			(7 (self sel_111:))
		)
	)
)

(instance creditTitle of Actor
	(properties
		sel_20 {creditTitle}
		sel_1 9
		sel_0 20
	)
)

(instance creditName of Actor
	(properties
		sel_20 {creditName}
		sel_1 86
		sel_0 220
		sel_4 1
		sel_14 16384
		sel_53 0
	)
)

(instance creditProp of Actor
	(properties
		sel_20 {creditProp}
		sel_2 792
	)
)

(instance volleyBall of Actor
	(properties
		sel_20 {volleyBall}
		sel_1 43
		sel_0 124
		sel_2 792
		sel_3 8
	)
)

(instance sunnyTwo of Prop
	(properties
		sel_20 {sunnyTwo}
		sel_1 286
		sel_0 179
		sel_2 792
		sel_3 7
	)
)

(instance wrapMusic of WrapMusic
	(properties
		sel_20 {wrapMusic}
	)
	
	(method (sel_110)
		(= sel_608 creditSound)
		(super sel_110: &rest)
	)
)

(instance creditSound of Sound
	(properties
		sel_20 {creditSound}
	)
)

(instance daggerEnd of View
	(properties
		sel_20 {daggerEnd}
		sel_1 88
		sel_0 85
		sel_2 401
		sel_4 1
	)
	
	(method (sel_300)
		(daggerInset sel_300: &rest)
	)
)

(instance daggerInset of Inset
	(properties
		sel_20 {daggerInset}
		sel_408 401
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(daggerEnd sel_110:)
		(gGame sel_588:)
		(gIconBar sel_177:)
	)
	
	(method (sel_133 param1)
		(gGame sel_587:)
		(param1 sel_73: 1)
		(daggerEnd sel_111:)
		(self sel_111:)
	)
)
