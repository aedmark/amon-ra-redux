;;; Sierra Script 1.0 - (do not remove this comment)
(script# 160)
(include sci.sh)
(use Main)
(use LBRoom)
(use MessageObj)
(use PolyPath)
(use n958)
(use StopWalk)
(use Cycle)
(use View)
(use Obj)

(public
	rm160 0
)

(local
	[local0 41] = [-1 1 0 0 1 0 0 0 -1 1 0 0 2 0 0 0 -1 1 0 0 3 0 0 0 -1 1 0 0 4 0 0 0 -1 1 0 0 5]
	[local41 25] = [-1 1 0 0 8 0 0 0 -1 1 0 0 9 0 0 0 -1 1 0 0 10]
	[local66 17] = [-1 1 0 0 11 0 0 0 -1 1 0 0 12]
)
(instance rm160 of LBRoom
	(properties
		sel_20 {rm160}
		sel_408 160
		sel_28 10
	)
	
	(method (sel_110)
		(proc958_0 128 163 826 162 161 160)
		(proc958_0 132 160 161 162 163)
		(gEgo sel_110: sel_585:)
		(self sel_414: 92)
		(super sel_110:)
		(thief sel_110:)
		(gSel_608 sel_40: 160 sel_99: 1 sel_3: -1 sel_39:)
		(self sel_146: sCartoon)
	)
	
	(method (sel_111)
		(gSel_608 sel_170: 0 30 12 1)
		(super sel_111: &rest)
	)
)

(instance sCartoon of Script
	(properties
		sel_20 {sCartoon}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo
					sel_2: 160
					sel_3: 0
					sel_4: 0
					sel_1: 137
					sel_0: 160
					sel_63: 8
					sel_161: End self
				)
			)
			(1
				(gEgo
					sel_3: 1
					sel_4: 0
					sel_1: 95
					sel_0: 167
					sel_161: End self
				)
			)
			(2
				(bag sel_110:)
				(gEgo
					sel_3: 2
					sel_4: 0
					sel_1: 120
					sel_0: 163
					sel_161: End self
				)
			)
			(3
				(trainLady
					sel_110:
					sel_161: Walk
					sel_312: MoveTo 140 125 self
				)
			)
			(4
				(trainLady sel_102:)
				(gEgo
					sel_2: 161
					sel_3: 0
					sel_4: 0
					sel_153: 128 167
					sel_161: End self
				)
				((ScriptID 1881 2) sel_203: 1)
				((ScriptID 1900 15) sel_203: 1)
			)
			(5
				(myConv sel_558: @local0 sel_110: self)
				(thief sel_146: sStealIt)
			)
			(6
				(if (thief sel_142?)
					(-- sel_29)
					(= sel_136 2)
				else
					(= sel_136 2)
				)
			)
			(7
				(gGameMusic2 sel_40: 162 sel_99: 1 sel_3: 1 sel_39:)
				(trainLady
					sel_3: 1
					sel_153: 110 160
					sel_216:
					sel_161: Walk
					sel_51: 4
					sel_52: 3
					sel_312: PolyPath -20 160 self
				)
				(gEgo
					sel_2: 162
					sel_3: 2
					sel_4: 0
					sel_153: 103 155
					sel_161: CT 4 1
				)
			)
			(8
				(trainLady sel_111:)
				(gEgo sel_161: Beg self)
			)
			(9 (gEgo sel_161: End self))
			(10
				(gLb2Messager sel_295: 1 0 0 6 self)
			)
			(11
				(thief
					sel_110:
					sel_2: 162
					sel_3: 0
					sel_153: -15 176
					sel_244: 5
					sel_53: 5
					sel_161: Walk
					sel_312: MoveTo 6 176 self
				)
			)
			(12
				(gLb2Messager sel_295: 1 0 0 7 self)
				(gGameMusic2 sel_40: 163 sel_99: 1 sel_3: -1 sel_39:)
			)
			(13
				(gEgo
					sel_2: 826
					sel_3: 2
					sel_161: StopWalk -1
					sel_312: PolyPath 37 176 self
				)
				((ScriptID 1881 2) sel_203: 1)
				((ScriptID 1901 16) sel_203: 1)
			)
			(14
				(thief sel_111:)
				(gEgo
					sel_2: 162
					sel_3: 1
					sel_4: 0
					sel_153: 24 176
					sel_244: 9
					sel_161: CT 5 1
				)
				(myConv sel_558: @local41 sel_110: self)
			)
			(15
				(myConv sel_558: @local66 sel_110: self)
				(gGameMusic2 sel_40: 164 sel_99: 1 sel_3: 1 sel_39: self)
			)
			(16
				(gLb2Messager sel_295: 1 0 0 13 self)
				(gEgo
					sel_2: 162
					sel_3: 1
					sel_153: 24 176
					sel_244: 9
					sel_161: End self
				)
			)
			(17 0)
			(18 0)
			(19
				(gEgo sel_244: 6)
				(global2 sel_399: 180)
				(self sel_111:)
			)
		)
	)
)

(instance sStealIt of Script
	(properties
		sel_20 {sStealIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(thief
					sel_161: Walk
					sel_244: 5
					sel_53: 5
					sel_312: PolyPath 110 167 self
				)
				(gGameMusic2 sel_40: 161 sel_99: 1 sel_3: 1 sel_39:)
			)
			(1
				(thief
					sel_3: 2
					sel_4: 1
					sel_153: 83 168
					sel_161: End self
				)
				(bag sel_111:)
			)
			(2
				(thief
					sel_153: 52 167
					sel_155: 3
					sel_161: Walk
					sel_244: 3
					sel_53: 3
					sel_51: 4
					sel_52: 3
					sel_312: PolyPath -20 167 self
				)
			)
			(3 (self sel_111:))
		)
	)
)

(instance trainLady of Actor
	(properties
		sel_20 {trainLady}
		sel_1 169
		sel_0 125
		sel_2 161
		sel_3 1
		sel_14 16384
	)
)

(instance thief of Actor
	(properties
		sel_20 {thief}
		sel_1 194
		sel_0 261
		sel_2 163
		sel_3 1
		sel_14 18432
		sel_244 8
		sel_53 8
	)
	
	(method (sel_145)
		(super sel_145:)
		(sCartoon sel_145:)
	)
)

(instance myConv of Conversation
	(properties
		sel_20 {myConv}
	)
)

(instance bag of View
	(properties
		sel_20 {bag}
		sel_1 73
		sel_0 158
		sel_2 160
		sel_3 3
		sel_14 16384
	)
)
