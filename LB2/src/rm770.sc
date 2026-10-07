;;; Sierra Script 1.0 - (do not remove this comment)
(script# 770)
(include sci.sh)
(use Main)
(use LBRoom)
(use RTRandCycle)
(use RandCycle)
(use n958)
(use Cycle)
(use View)
(use Obj)

(public
	rm770 0
	O_Riley 19
)

(local
	local0
	local1
	local2
	local3
)
(instance rm770 of LBRoom
	(properties
		sel_20 {rm770}
		sel_408 770
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 770 771)
		(proc958_0 132 770)
		(super sel_110:)
		(gSel_608 sel_40: 771 sel_3: -1 sel_99: 1 sel_39:)
		(gIconBar sel_233:)
		(gGame sel_197: 996)
		(bird sel_110: sel_146: sFly)
		(bird2 sel_110: sel_146: sLand 0 4)
		(murderer sel_110:)
		(cop2 sel_110: sel_146: (sRandomScr sel_109:))
		(cop3 sel_110:)
		(cop5 sel_110:)
		(cop6 sel_110:)
		(badguy1 sel_110: sel_146: (sRandomScr sel_109:))
		(badguy2 sel_110: sel_146: sRandomScr2)
		(badguy3 sel_110:)
		(self sel_146: sRunIt)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 12 30 1)
		(super sel_111:)
	)
)

(instance sFly of Script
	(properties
		sel_20 {sFly}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sel_42 sel_155: (Random 0 3) sel_63: 15 sel_161: Fwd)
				(switch (sel_42 sel_3?)
					(0
						(sel_42 sel_153: 329 30 sel_312: MoveTo -10 17 self)
					)
					(1
						(sel_42 sel_153: -10 17 sel_312: MoveTo 329 30 self)
					)
					(2
						(sel_42 sel_153: -10 95 sel_312: MoveTo 174 -15 self)
					)
					(3
						(sel_42 sel_153: 329 136 sel_312: MoveTo 198 -17 self)
					)
				)
			)
			(1 (self sel_144: 0))
		)
	)
)

(instance sLand of Script
	(properties
		sel_20 {sLand}
	)
	
	(method (sel_144 theSel_29 &tmp temp0 temp1)
		(switch (= sel_29 theSel_29)
			(0
				(= temp0 (if (== sel_141 4) 199 else 171))
				(= temp1 (if (== sel_141 4) 116 else 124))
				(sel_42
					sel_155: sel_141
					sel_161: Fwd
					sel_312: MoveTo temp0 temp1 self
				)
			)
			(1
				(sel_42 sel_155: (+ sel_141 2) sel_161: End self)
			)
			(2
				(sel_42
					sel_155: (+ sel_141 4)
					sel_244: 10
					sel_161: RandCycle
				)
				(if (== sel_42 bird2)
					(bird3 sel_110: sel_146: (sLand sel_109:) 0 5)
				)
			)
		)
	)
)

(instance sRunIt of Script
	(properties
		sel_20 {sRunIt}
	)
	
	(method (sel_57)
		(super sel_57:)
		(if
			(and
				(not local1)
				(== (murderer sel_4?) 4)
				(== (murderer sel_3?) 0)
			)
			(gGameMusic2
				sel_40: 770
				sel_99: 5
				sel_3: 1
				sel_39: murderer
			)
			(= local1 1)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= local0 1) (= sel_136 1))
			(1
				(gLb2Messager sel_295: 1 0 0 local0 self)
			)
			(2 (murderer sel_161: End self))
			(3
				(if (< (++ local0) 4)
					(self sel_144: 1)
				else
					(gLb2Messager sel_295: 1 0 0 4 self)
				)
			)
			(4
				(murderer sel_161: CT 4 1 self)
			)
			(5
				(gGameMusic2 sel_40: 770 sel_99: 5 sel_3: 1 sel_39:)
				(murderer sel_3: 1 sel_4: 0 sel_161: End self)
			)
			(6
				(gLb2Messager sel_295: 1 0 0 5 self)
			)
			(7
				(gLb2Messager sel_295: 1 0 0 6 self)
			)
			(8
				(gSel_608 sel_40: 772 sel_99: 1 sel_3: 1 sel_39: self)
			)
			(9
				(global2 sel_399: (if (== global126 1) 775 else 785))
			)
		)
	)
)

(instance sRandomScr of Script
	(properties
		sel_20 {sRandomScr}
	)
	
	(method (sel_57)
		(super sel_57:)
		(if
			(and
				(not local2)
				(== (sel_42 sel_4?) 4)
				(!= (sel_42 sel_3?) 5)
			)
			(gGameMusic2
				sel_40: 770
				sel_99: 5
				sel_3: 1
				sel_39: badguy1
			)
			(= local2 1)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_139 (Random 30 120)))
			(1 (sel_42 sel_161: End self))
			(2 (self sel_144: 0))
		)
	)
)

(instance sRandomScr2 of Script
	(properties
		sel_20 {sRandomScr2}
	)
	
	(method (sel_57)
		(super sel_57:)
		(if (and (not local3) (== (sel_42 sel_4?) 4))
			(gGameMusic2
				sel_40: 770
				sel_99: 5
				sel_3: 1
				sel_39: badguy2
			)
			(= local3 1)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_139 (Random 30 120)))
			(1 (sel_42 sel_161: End self))
			(2 (self sel_144: 0))
		)
	)
)

(instance bird of Actor
	(properties
		sel_20 {bird}
		sel_1 -10
		sel_0 17
		sel_2 771
		sel_3 1
		sel_14 24576
		sel_244 0
		sel_53 0
	)
)

(instance bird2 of Actor
	(properties
		sel_20 {bird2}
		sel_1 329
		sel_0 8
		sel_2 771
		sel_3 4
		sel_14 24576
		sel_244 0
		sel_53 0
	)
)

(instance bird3 of Actor
	(properties
		sel_20 {bird3}
		sel_1 58
		sel_0 -18
		sel_2 771
		sel_3 5
		sel_14 24576
		sel_244 0
		sel_53 0
	)
)

(instance murderer of Prop
	(properties
		sel_20 {murderer}
		sel_1 162
		sel_0 176
		sel_2 770
		sel_4 9
		sel_244 15
	)
	
	(method (sel_145)
		(= local1 0)
		(super sel_145:)
	)
)

(instance cop2 of Prop
	(properties
		sel_20 {cop2}
		sel_1 207
		sel_0 45
		sel_2 770
		sel_3 5
		sel_4 8
		sel_244 15
	)
)

(instance cop3 of Prop
	(properties
		sel_20 {cop3}
		sel_1 243
		sel_0 49
		sel_2 770
		sel_3 6
		sel_4 6
	)
)

(instance cop5 of Prop
	(properties
		sel_20 {cop5}
		sel_1 275
		sel_0 155
		sel_2 770
		sel_3 6
		sel_4 5
	)
)

(instance cop6 of Prop
	(properties
		sel_20 {cop6}
		sel_1 45
		sel_0 151
		sel_2 770
		sel_3 6
		sel_4 4
	)
)

(instance badguy1 of Prop
	(properties
		sel_20 {badguy1}
		sel_1 280
		sel_0 131
		sel_2 770
		sel_3 3
		sel_4 3
		sel_244 15
	)
	
	(method (sel_145)
		(= local2 0)
		(super sel_145:)
	)
)

(instance badguy2 of Prop
	(properties
		sel_20 {badguy2}
		sel_1 247
		sel_0 154
		sel_2 770
		sel_3 2
		sel_244 15
	)
	
	(method (sel_145)
		(= local3 0)
		(super sel_145:)
	)
)

(instance badguy3 of Prop
	(properties
		sel_20 {badguy3}
		sel_1 313
		sel_0 136
		sel_2 770
		sel_3 4
	)
)

(instance O_Riley of Narrator
	(properties
		sel_20 {O'Riley}
		sel_1 10
		sel_0 155
		sel_203 1
		sel_26 15
		name "O'Riley"
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)
