;;; Sierra Script 1.0 - (do not remove this comment)
(script# 240)
(include sci.sh)
(use Main)
(use LBRoom)
(use MessageObj)
(use RTRandCycle)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Timer)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm240 0
	local_Steve 12
)

(local
	[local0 57] = [-1 10 6 19 1 0 0 0 -1 10 6 19 2 0 0 0 -1 10 6 19 3 0 0 0 -1 10 6 19 4 0 0 0 -1 10 6 19 5 0 0 0 -1 10 6 19 6 0 0 0 -1 10 6 19 7]
	local57
	local58
	local59
)
(instance rm240 of LBRoom
	(properties
		sel_20 {rm240}
		sel_408 120
		sel_28 10
		sel_410 250
		sel_107 187
		sel_108 135
	)
	
	(method (sel_110)
		(proc958_0 128 852 284 1125 125 830 121)
		(proc958_0 132 40 120 121)
		(gEgo
			sel_110:
			sel_320: Scaler 145 20 187 135
			sel_585: 830
		)
		(switch gGSel_40
			(sel_410
				(if (proc0_2 9)
					(global2 sel_146: sEnterEastN)
				else
					(steve sel_110: sel_320: Scaler 197 10 187 135)
					(self
						sel_395:
							(= local59
								((Polygon sel_109:)
									sel_31: 2
									sel_110: 199 159 199 171 160 171 160 159
									sel_117:
								)
							)
					)
					(global2 sel_146: sEnterEast1)
				)
			)
			(else 
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 3
					sel_110:
						84
						154
						83
						176
						183
						176
						243
						176
						243
						164
						212
						164
						212
						154
						242
						154
						242
						142
						162
						142
						91
						154
					sel_117:
				)
		)
		(gSel_608 sel_40: 121 sel_3: -1 sel_99: 1 sel_39:)
		(gGameMusic2 sel_170:)
		(person1 sel_110: sel_338: 1 1)
		(person2 sel_110: sel_338: 1 1)
		(person3 sel_110: sel_338: 1 1)
		(taxiSign sel_110:)
		(ship sel_110:)
		(crate sel_110:)
		(warehouses sel_110:)
		(city sel_110:)
		(city1 sel_110:)
		(cityLeft sel_110:)
		(sky sel_110:)
		(skyleft sel_110:)
		(water sel_110:)
		(pilingRt sel_110:)
		(pilingL sel_110:)
		(docks sel_110:)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 256) (global2 sel_146: sHitEdgeScreen))
		)
	)
	
	(method (sel_111)
		(gSel_608 sel_170:)
		(noConvTimer sel_111: sel_81:)
		(super sel_111:)
	)
)

(instance sEnterEast1 of Script
	(properties
		sel_20 {sEnterEast1}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 22 0) sel_57: 2)
				(gGame sel_87: 1 130)
				((ScriptID 1881 2)
					sel_1: 203
					sel_0: 17
					sel_549: -180
					sel_550: 0
				)
				(gEgo
					sel_349: 0
					sel_153: 250 159
					sel_253: 270
					sel_312: MoveFwd 38 self
				)
				(steve
					sel_155: 5
					sel_161: Walk
					sel_312: MoveTo 180 166 self
				)
			)
			(1 0)
			(2
				(steve
					sel_155: 8
					sel_4: 0
					sel_153: 180 165
					sel_244: 12
					sel_146: sSteveAnimates
				)
				(gGame sel_588:)
				(proc0_3 9)
				(person1 sel_146: moveItAround)
				(= sel_137 1)
			)
			(3
				(gLb2Messager sel_295: 14 0 0 1)
				(person3 sel_146: (moveItAround sel_109:))
				(= sel_137 1)
			)
			(4
				(person2 sel_146: (moveItAround sel_109:))
				(= sel_137 1)
			)
			(5
				(noConvTimer sel_162: noConvTimer 15)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterEastN of Script
	(properties
		sel_20 {sEnterEastN}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_349: 0
					sel_153: 250 150
					sel_253: 270
					sel_312: MoveFwd 35 self
				)
			)
			(1
				(gGame sel_588:)
				(person1 sel_146: moveItAround)
				(= sel_137 2)
			)
			(2
				(person3 sel_146: (moveItAround sel_109:))
				(= sel_136 5)
			)
			(3
				(person2 sel_146: (moveItAround sel_109:))
				(= sel_137 6)
			)
			(4 (self sel_111:))
		)
	)
)

(instance sSteveAnimates of Script
	(properties
		sel_20 {sSteveAnimates}
	)
	
	(method (sel_144 theSel_29 &tmp temp0)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 (Random 4 8)))
			(1
				(switch (= temp0 (Random 0 3))
					(0
						(steve sel_3: 8 sel_161: End self)
					)
					(1
						(if (== (Random 0 3) 0)
							(steve sel_3: 9 sel_161: End self)
						else
							(= temp0 3)
							(= sel_136 1)
						)
					)
					(2
						(steve sel_3: 10 sel_161: End self)
					)
					(3 (= sel_137 (Random 2 4)))
				)
			)
			(2 (= sel_137 (Random 4 8)))
			(3
				(if (!= temp0 3)
					(steve sel_161: Beg self)
				else
					(= sel_136 1)
				)
			)
			(4 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance moveItAround of Script
	(properties
		sel_20 {moveItAround}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sel_42 sel_312: MoveTo 194 127 self)
			)
			(1
				(sel_42 sel_153: 234 137 sel_312: MoveTo 191 138 self)
			)
			(2
				(switch (Random 0 1)
					(0
						(sel_42
							sel_312: MoveTo (Random 138 174) (Random 136 140) self
						)
					)
					(1 (= sel_137 2))
				)
			)
			(3
				(sel_42 sel_312: MoveTo 191 138 self)
			)
			(4
				(sel_42 sel_312: MoveTo 234 137 self)
			)
			(5
				(sel_42 sel_3: (Random 0 4) sel_153: 169 121)
				(= sel_137 2)
			)
			(6 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sTalkSteve of Script
	(properties
		sel_20 {sTalkSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(noConvTimer sel_162: noConvTimer 15)
				(= sel_136 1)
			)
			(1
				((ScriptID 21 0) sel_57: 263)
				(if (< (gEgo sel_1?) 181)
					(gEgo sel_312: PolyPath 162 165 self)
				else
					(gEgo sel_312: PolyPath 204 169 self)
				)
			)
			(2 (proc0_5 gEgo steve self))
			(3 (= sel_136 4))
			(4
				(switch (++ local57)
					(1
						(gLb2Messager sel_295: 10 2 1 0 self)
						((ScriptID 21 0) sel_57: 263)
					)
					(2
						(gLb2Messager sel_295: 10 2 2 0 self)
					)
					(3
						(gLb2Messager sel_295: 10 2 3 0 self)
					)
					(4
						(gLb2Messager sel_295: 10 2 4 0 self)
					)
					(5
						(gLb2Messager sel_295: 10 2 5 0 self)
					)
					(else 
						(gLb2Messager sel_295: 10 2 6 0 self)
					)
				)
				(= sel_137 1)
			)
			(5 (= sel_136 4))
			(6
				(noConvTimer sel_162: noConvTimer 15)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sAskSteve of Script
	(properties
		sel_20 {sAskSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(noConvTimer sel_162: noConvTimer 15)
				(= sel_136 1)
			)
			(1
				((ScriptID 21 0) sel_57: 263)
				(if (< (gEgo sel_1?) 181)
					(gEgo sel_312: PolyPath 162 165 self)
				else
					(gEgo sel_312: PolyPath 204 169 self)
				)
			)
			(2 (proc0_5 gEgo steve self))
			(3
				(gGame sel_587:)
				(= sel_136 4)
			)
			(4
				(switch (global2 sel_422: (ScriptID 20 0))
					(262
						(gLb2Messager sel_295: 10 6 7 0 self)
					)
					(261
						(gLb2Messager sel_295: 10 6 8 0 self)
					)
					(264
						(gLb2Messager sel_295: 10 6 9 0 self)
					)
					(260
						(gLb2Messager sel_295: 10 6 10 0 self)
					)
					(259
						((ScriptID 21 0) sel_57: 269)
						(gLb2Messager sel_295: 10 6 11 0 self)
					)
					(269
						(gLb2Messager sel_295: 10 6 12 0 self)
					)
					(258
						(switch (++ local58)
							(1
								(gLb2Messager sel_295: 10 6 13 0 self)
							)
							(else 
								(gLb2Messager sel_295: 10 6 14 0 self)
							)
						)
					)
					(263
						(gLb2Messager sel_295: 10 6 26 0 self)
					)
					(780
						((ScriptID 21 0) sel_57: 258)
						(gLb2Messager sel_295: 10 6 15 0 self)
					)
					(518
						(gLb2Messager sel_295: 10 6 16 0 self)
					)
					(516
						(gLb2Messager sel_295: 10 6 17 0 self)
					)
					(514
						(gLb2Messager sel_295: 10 6 18 0 self)
					)
					(519
						(gLb2Messager sel_295: 10 6 27 0 self)
					)
					(517
						(self sel_146: sAskMuseum self)
					)
					(1026
						(gLb2Messager sel_295: 10 6 28 0 self)
					)
					(773
						(gLb2Messager sel_295: 10 6 20 0 self)
					)
					(772
						(gLb2Messager sel_295: 10 6 22 0 self)
					)
					(769
						(gLb2Messager sel_295: 10 6 21 0 self)
					)
					(771
						(gLb2Messager sel_295: 10 6 23 0 self)
					)
					(-1 (= sel_136 1))
					(else 
						(gLb2Messager sel_295: 10 6 25 0 self)
					)
				)
			)
			(5 (= sel_136 4))
			(6
				(if (gSel_561 sel_122: steve)
					(noConvTimer sel_162: noConvTimer 15)
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sAskMuseum of Script
	(properties
		sel_20 {sAskMuseum}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(noConvTimer sel_111: sel_81:)
				((ScriptID 21 0) sel_57: 258)
				(myConv sel_558: @local0 sel_110: self)
				(steve sel_146: 0)
			)
			(1
				(steve
					sel_155: 6
					sel_153: (- (steve sel_1?) 2) (+ (steve sel_0?) 3)
					sel_316: 1
					sel_161: End self
				)
			)
			(2
				(steve
					sel_155: 7
					sel_153: (+ (steve sel_1?) 2) (- (steve sel_0?) 1)
					sel_253: 0
					sel_338: 1 1
					sel_53: 9
					sel_161: Walk
					sel_312: MoveTo (steve sel_1?) 140 self
				)
				(= sel_137 5)
			)
			(3
				(if sel_137 (= sel_137 0))
				(gGame sel_588:)
				(steve sel_111:)
				((global2 sel_259?) sel_81: local59)
				(local59 sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance sHailCab of Script
	(properties
		sel_20 {sHailCab}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(if (gSel_561 sel_122: steve) (steve sel_146: 0))
				(gEgo sel_312: PolyPath 213 152 self)
			)
			(2
				(gEgo
					sel_2: 852
					sel_3: 0
					sel_4: 0
					sel_320: Scaler 170 20 187 135
					sel_161: End self
				)
				(if (gSel_561 sel_122: steve)
					(steve
						sel_155: 7
						sel_253: 0
						sel_338: 1 1
						sel_53: 9
						sel_312: MoveTo (steve sel_1?) 140
					)
				)
				(noise sel_40: 97 sel_99: 1 sel_39:)
			)
			(3
				(taxi
					sel_110:
					sel_63: 11
					sel_320: Scaler 187 70 187 135
					sel_155: 4
				)
				(= sel_136 1)
			)
			(4
				(gGameMusic2 sel_39:)
				(taxi sel_312: MoveTo 281 154 self)
			)
			(5
				(taxi sel_312: MoveTo 293 163 self)
			)
			(6
				(gEgo
					sel_585: 830
					sel_253: 90
					sel_320: Scaler 145 20 187 135
					sel_312: MoveFwd 32 self
				)
			)
			(7
				(noise sel_40: 40 sel_99: 5 sel_39: self)
			)
			(8 (global2 sel_399: 250))
		)
	)
)

(instance sHitEdgeScreen of Script
	(properties
		sel_20 {sHitEdgeScreen}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gLb2Messager sel_295: 4 3 0 0 self 91)
			)
			(2
				(if (> (gEgo sel_55?) 180)
					(gEgo sel_253: 90)
				else
					(gEgo sel_253: 270)
				)
				(gEgo sel_312: MoveFwd 25 self)
			)
			(3
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance person1 of Actor
	(properties
		sel_20 {person1}
		sel_1 169
		sel_0 121
		sel_2 121
		sel_60 3
		sel_14 18448
		sel_103 1
		sel_53 25
	)
)

(instance person2 of Actor
	(properties
		sel_20 {person2}
		sel_1 169
		sel_0 121
		sel_2 121
		sel_3 1
		sel_60 3
		sel_14 18448
		sel_103 1
		sel_53 27
	)
)

(instance person3 of Actor
	(properties
		sel_20 {person3}
		sel_1 169
		sel_0 121
		sel_2 121
		sel_3 2
		sel_60 3
		sel_14 18448
		sel_103 1
		sel_53 24
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 184
		sel_0 140
		sel_213 9
		sel_2 121
		sel_3 5
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(2
				(global2 sel_146: sTalkSteve)
			)
			(6 (global2 sel_146: sAskSteve))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance taxiSign of View
	(properties
		sel_20 {taxiSign}
		sel_1 225
		sel_0 160
		sel_213 13
		sel_2 284
		sel_4 2
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (global2 sel_146: sHailCab))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance taxi of Actor
	(properties
		sel_20 {taxi}
		sel_1 290
		sel_0 146
		sel_2 852
		sel_3 4
	)
)

(instance ship of Feature
	(properties
		sel_20 {ship}
		sel_0 100
		sel_213 1
		sel_302 16384
	)
)

(instance crate of Feature
	(properties
		sel_20 {crate}
		sel_1 113
		sel_0 189
		sel_213 5
		sel_6 164
		sel_7 88
		sel_8 179
		sel_9 139
		sel_301 40
	)
)

(instance warehouses of Feature
	(properties
		sel_20 {warehouses}
		sel_1 209
		sel_0 128
		sel_213 4
		sel_6 121
		sel_7 189
		sel_8 136
		sel_9 230
		sel_301 40
	)
)

(instance city of Feature
	(properties
		sel_20 {city}
		sel_1 199
		sel_0 82
		sel_213 3
		sel_6 46
		sel_7 188
		sel_8 119
		sel_9 210
		sel_301 40
	)
)

(instance city1 of Feature
	(properties
		sel_20 {city1}
		sel_1 204
		sel_0 93
		sel_213 3
		sel_6 67
		sel_7 177
		sel_8 120
		sel_9 231
		sel_301 40
	)
)

(instance cityLeft of Feature
	(properties
		sel_20 {cityLeft}
		sel_1 95
		sel_0 100
		sel_213 3
		sel_6 72
		sel_7 88
		sel_8 128
		sel_9 103
		sel_301 40
	)
)

(instance sky of Feature
	(properties
		sel_20 {sky}
		sel_1 199
		sel_0 26
		sel_213 2
		sel_6 8
		sel_7 168
		sel_8 45
		sel_9 231
		sel_301 40
	)
)

(instance skyleft of Feature
	(properties
		sel_20 {skyleft}
		sel_1 107
		sel_0 20
		sel_213 2
		sel_6 6
		sel_7 89
		sel_8 35
		sel_9 126
		sel_301 40
	)
)

(instance water of Feature
	(properties
		sel_20 {water}
		sel_1 99
		sel_0 139
		sel_213 7
		sel_6 135
		sel_7 87
		sel_8 144
		sel_9 112
		sel_301 40
	)
)

(instance pilingRt of Feature
	(properties
		sel_20 {pilingRt}
		sel_1 214
		sel_0 168
		sel_213 8
		sel_6 151
		sel_7 198
		sel_8 185
		sel_9 230
		sel_301 40
	)
)

(instance pilingL of Feature
	(properties
		sel_20 {pilingL}
		sel_1 171
		sel_0 176
		sel_213 8
		sel_6 169
		sel_7 150
		sel_8 183
		sel_9 193
		sel_301 40
	)
)

(instance docks of Feature
	(properties
		sel_20 {docks}
		sel_0 160
		sel_213 6
		sel_302 8192
	)
)

(instance myConv of Conversation
	(properties
		sel_20 {myConv}
	)
)

(instance local_Steve of Talker
	(properties
		sel_20 {local Steve}
		sel_1 9
		sel_0 85
		sel_2 125
		sel_3 3
		sel_60 15
		sel_14 16
		sel_291 0
		sel_537 130
		sel_26 15
		sel_549 130
		sel_550 -75
		name "local Steve"
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: 0 tSteveEyes tSteveMouth &rest)
	)
)

(instance tSteveMouth of Prop
	(properties
		sel_20 {tSteveMouth}
		sel_6 34
		sel_7 57
		sel_2 1125
		sel_60 15
		sel_14 16400
	)
)

(instance tSteveEyes of Prop
	(properties
		sel_20 {tSteveEyes}
		sel_6 29
		sel_7 58
		sel_2 1125
		sel_3 2
		sel_60 15
		sel_14 16400
	)
)

(instance noConvTimer of Timer
	(properties
		sel_20 {noConvTimer}
	)
	
	(method (sel_145)
		(cond 
			(
				(and
					(not (global2 sel_142?))
					(gSel_561 sel_122: steve)
				)
				(gLb2Messager sel_295: 14 0 0 2)
				(noConvTimer sel_162: noConvTimer 15)
			)
			((not (gSel_561 sel_122: steve)) (noConvTimer sel_111: sel_81:))
			(else (self sel_162: self 5))
		)
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)
