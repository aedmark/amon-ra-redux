;;; Sierra Script 1.0 - (do not remove this comment)
(script# 290)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use RTRandCycle)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm290 0
	theWanderer 38
)

(local
	local0
	local1 =  1
	local2
)
(instance rm290 of LBRoom
	(properties
		sel_20 {rm290}
		sel_213 15
		sel_408 290
		sel_409 295
		sel_411 280
	)
	
	(method (sel_110)
		(proc958_0 128 290 291 293 292)
		(proc958_0 132 292 280)
		(gEgo sel_110: sel_585: 830 sel_320: Scaler 137 0 190 0)
		(switch gGSel_40
			(sel_409
				(gEgo sel_349: 0 sel_253: 180)
			)
			(sel_411
				(gEgo sel_153: 160 230)
				(global2 sel_146: sComeInSouth)
			)
			(else 
				(gEgo sel_153: 140 173)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						0
						0
						319
						0
						319
						189
						308
						144
						281
						145
						273
						146
						261
						152
						236
						157
						199
						157
						197
						164
						175
						169
						27
						137
						27
						129
						96
						124
						97
						117
						44
						118
						28
						81
						27
						120
						11
						123
						0
						189
					sel_117:
				)
				((Polygon sel_109:)
					sel_31: 2
					sel_110: 64 189 85 171 107 189
					sel_117:
				)
		)
		(officeDoor sel_110: sel_590: (proc0_2 43))
		(happyWanderer sel_110: sel_146: sWander)
		(sergeant
			sel_110:
			sel_311: 1 6 2 4 7 8
			sel_146: sMoveSergeant
		)
		(southExitFeature sel_110:)
		(southExitFeature2 sel_110:)
		(files sel_110:)
		(desk sel_110:)
		(poster1 sel_110:)
		(poster2 sel_110:)
		(poster3 sel_110:)
		(poster4 sel_110:)
		(poster5 sel_110:)
		(poster6 sel_110:)
		(pole sel_110:)
	)
	
	(method (sel_57)
		(cond 
			(sel_142)
			((proc0_1 gEgo 16) (self sel_146: sEgoLeaveSouth))
		)
		(super sel_57: &rest)
	)
	
	(method (sel_111)
		(super sel_111: &rest)
	)
)

(instance sEgoLeaveSouth of Script
	(properties
		sel_20 {sEgoLeaveSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_55: 180)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveFwd 80 self)
			)
			(2 (global2 sel_399: 280))
		)
	)
)

(instance sComeInSouth of Script
	(properties
		sel_20 {sComeInSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: MoveTo 160 175 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sKnock of Script
	(properties
		sel_20 {sKnock}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(knockSound sel_39: self)
			)
			(1
				(gLb2Messager sel_295: 3 4 0 0 self)
			)
			(2
				(= local2 1)
				(officeDoor sel_300: 4)
				(self sel_111:)
			)
		)
	)
)

(instance sMoveSergeant of Script
	(properties
		sel_20 {sMoveSergeant}
	)
	
	(method (sel_57)
		(if
			(and
				(not local0)
				(sergeant sel_245?)
				(== (sergeant sel_4?) 3)
			)
			(shuffleSound sel_39: sergeant)
			(= local0 1)
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sergeant sel_161: Fwd)
				(= sel_137 (Random 1 6))
			)
			(1
				(sergeant sel_161: 0)
				(= sel_137 (Random 2 4))
			)
			(2 (self sel_110:))
		)
	)
)

(instance sGiveSandwich of Script
	(properties
		sel_20 {sGiveSandwich}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 252 152 self)
			)
			(1 (proc0_5 gEgo sergeant self))
			(2
				(sergeant sel_146: 0)
				(sergeant
					sel_3: 1
					sel_4: 0
					sel_244: 10
					sel_161: CT 8 1 self
				)
				(gEgo
					sel_2: 292
					sel_153: 240 152
					sel_3: 1
					sel_4: 0
					sel_244: 10
					sel_161: CT 4 1 self
				)
			)
			(3 (gLb2Messager sel_295: 2 15))
			(4
				(gEgo sel_161: End self)
				(sergeant sel_161: End self)
			)
			(5 0)
			(6
				(sergeant sel_3: 0 sel_146: sMoveSergeant)
				(proc0_3 7)
				((ScriptID 21 1) sel_57: 772)
				(gEgo sel_351: 3)
				(gEgo sel_585: 830)
				(gEgo sel_3: 7 sel_153: 254 152 sel_253: 315)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sWander of Script
	(properties
		sel_20 {sWander}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 (Random 3 20)))
			(1
				(sel_42 sel_161: Walk sel_312: MoveTo 154 122 self)
			)
			(2 (= sel_139 (Random 30 240)))
			(3
				(sel_42 sel_155: 2 sel_4: 0 sel_161: End self)
			)
			(4
				(sel_42
					sel_155: 1
					sel_161: Walk
					sel_312: MoveTo -20 141 self
				)
			)
			(5
				(sel_42 sel_111:)
				(self sel_111:)
			)
		)
	)
)

(instance happyWanderer of Actor
	(properties
		sel_20 {happyWanderer}
		sel_1 -20
		sel_0 141
		sel_213 1
		sel_2 293
		sel_14 4096
	)
)

(instance sergeant of Prop
	(properties
		sel_20 {sergeant}
		sel_1 220
		sel_0 116
		sel_213 2
		sel_303 254
		sel_304 152
		sel_2 291
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(switch param1
			(15
				(global2 sel_146: sGiveSandwich)
			)
			(2
				(cond 
					((proc0_2 7) (= temp1 73))
					(local1 (= temp1 78))
					(else (= temp1 79))
				)
				(gLb2Messager sel_295: 2 2 temp1)
				(= local1 0)
			)
			(6
				(if (not (proc0_2 7))
					(gLb2Messager sel_295: 2 6 70)
				else
					(if
						(==
							(= temp0
								(if (== argc 2)
									param2
								else
									(global2 sel_422: (ScriptID 20 0))
								)
							)
							-1
						)
						(return)
					)
					(= temp2 (& temp0 $00ff))
					(= temp1
						(switch (& temp0 $ff00)
							(256 (+ temp2 1))
							(512 (+ temp2 18))
							(768 (+ temp2 26))
							(1024 (+ temp2 61))
						)
					)
					(switch temp0
						(260
							(if (officeDoor sel_590?)
								(gLb2Messager sel_295: 2 6 71)
							else
								(gLb2Messager sel_295: 2 6 5)
							)
						)
						(520
							(gLb2Messager sel_295: 2 6 26)
							((ScriptID 21 0) sel_57: 1029)
						)
						(264
							(gLb2Messager sel_295: 2 6 9)
							((ScriptID 21 1) sel_57: 518)
							((ScriptID 21 0) sel_57: 520)
						)
						(else 
							(if (Message msgGET gSel_40 sel_213 6 temp1 1)
								(gLb2Messager sel_295: sel_213 6 temp1)
							else
								(gLb2Messager sel_295: sel_213 6 43)
							)
						)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(= local0 0)
		(super sel_145:)
	)
)

(instance officeDoor of Door
	(properties
		sel_20 {officeDoor}
		sel_1 18
		sel_0 57
		sel_213 3
		sel_303 58
		sel_304 125
		sel_2 290
		sel_589 295
		sel_597 37
		sel_598 110
		sel_599 0
		sel_600 0
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					(local2 (super sel_300: param1 &rest))
					((not (self sel_590?)) (gEgo sel_146: sKnock))
					(else (proc0_5 gEgo officeDoor) (super sel_300: param1 &rest))
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
	
	(method (sel_606)
		(super sel_606: 12 112 55 112 54 121 15 122)
	)
)

(instance theWanderer of Narrator
	(properties
		sel_20 {theWanderer}
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)

(instance files of Feature
	(properties
		sel_20 {files}
		sel_0 2
		sel_213 4
		sel_6 76
		sel_7 150
		sel_8 98
		sel_9 204
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_0 1
		sel_213 5
		sel_6 98
		sel_7 58
		sel_8 151
		sel_9 261
	)
)

(instance poster1 of Feature
	(properties
		sel_20 {poster1}
		sel_0 189
		sel_213 6
		sel_6 34
		sel_7 75
		sel_8 55
		sel_9 100
	)
)

(instance poster2 of Feature
	(properties
		sel_20 {poster2}
		sel_0 189
		sel_213 7
		sel_6 64
		sel_7 84
		sel_8 79
		sel_9 101
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(4 (poster1 sel_300: 4))
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance poster3 of Feature
	(properties
		sel_20 {poster3}
		sel_0 189
		sel_213 8
		sel_6 66
		sel_7 69
		sel_8 85
		sel_9 79
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(4 (poster1 sel_300: 4))
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance poster4 of Feature
	(properties
		sel_20 {poster4}
		sel_0 189
		sel_213 9
		sel_6 85
		sel_7 74
		sel_8 106
		sel_9 81
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(4 (poster1 sel_300: 4))
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance poster5 of Feature
	(properties
		sel_20 {poster5}
		sel_0 189
		sel_213 10
		sel_6 100
		sel_7 84
		sel_8 114
		sel_9 94
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(4 (poster1 sel_300: 4))
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance poster6 of Feature
	(properties
		sel_20 {poster6}
		sel_0 189
		sel_213 11
		sel_6 117
		sel_7 69
		sel_8 137
		sel_9 95
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(4 (poster1 sel_300: 4))
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance pole of Feature
	(properties
		sel_20 {pole}
		sel_0 188
		sel_213 12
		sel_7 71
		sel_8 189
		sel_9 100
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_7 111
		sel_8 189
		sel_9 320
		sel_33 11
		sel_583 3
		sel_213 14
	)
)

(instance southExitFeature2 of ExitFeature
	(properties
		sel_20 {southExitFeature2}
		sel_6 184
		sel_8 189
		sel_9 63
		sel_33 11
		sel_583 3
		sel_213 14
	)
)

(instance shuffleSound of Sound
	(properties
		sel_20 {shuffleSound}
		sel_99 5
		sel_40 292
	)
)

(instance knockSound of Sound
	(properties
		sel_20 {knockSound}
		sel_99 1
		sel_40 297
	)
)
