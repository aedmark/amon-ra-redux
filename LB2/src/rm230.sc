;;; Sierra Script 1.0 - (do not remove this comment)
(script# 230)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use RTRandCycle)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use Cycle)
(use InvI)
(use View)
(use Obj)

(public
	rm230 0
	Laura 2
	Crodfoller 7
	ManWriting 37
)

(local
	local0 =  1
	local1 =  1
	local2 =  1
)
(instance rm230 of LBRoom
	(properties
		sel_20 {rm230}
		sel_213 18
		sel_408 230
		sel_411 210
		sel_107 150
		sel_108 90
	)
	
	(method (sel_110)
		(proc958_0 128 231 232 233 238 1231 1230 830 829)
		(Load rsSOUND 210)
		(gEgo
			sel_14: 4096
			sel_110:
			sel_326: (if (== gGSel_40 235) 0 else checkScaling)
			sel_585: 830
			sel_320: Scaler 190 40 190 90
		)
		(switch gGSel_40
			(sel_411
				(global2 sel_146: sEnterNorth)
			)
			(26
				(gEgo sel_1: 160 sel_0: 160)
				((Inv sel_64: 2) sel_166: gEgo)
				(proc0_5 gEgo crod)
				(self sel_146: sDoTalking)
			)
			(18
				(self sel_146: sCopyProBack)
			)
			(235
				(gEgo
					sel_2: 231
					sel_155: 0
					sel_4: 10
					sel_63: 11
					sel_1: 211
					sel_0: 164
					sel_161: 0
				)
				(gLb2WH sel_129: global2)
				(gLb2DH sel_129: global2)
				(gGame sel_588:)
			)
			(else 
				(gGame sel_588:)
				(gEgo sel_153: 160 160)
			)
		)
		(super sel_110:)
		(self
			sel_395:
				((Polygon sel_109:)
					sel_31: 2
					sel_110:
						319
						0
						319
						189
						313
						189
						313
						164
						254
						164
						242
						158
						219
						158
						207
						165
						142
						158
						142
						148
						113
						148
						103
						158
						45
						158
						5
						167
						5
						189
						0
						189
						0
						0
					sel_117:
				)
		)
		(gSel_608 sel_40: 210 sel_3: -1 sel_99: 1 sel_39:)
		(personS sel_110: sel_244: 10 sel_161: RandCycle)
		(personT sel_110: sel_244: 10 sel_161: RandCycle)
		(person1 sel_110: sel_146: sMoveIt)
		(person2 sel_110: sel_146: sMoveIt2)
		(gentsDoor sel_311: 1 4 sel_110:)
		(crod sel_311: 1 4 2 6 sel_146: sTypeAwayCrod sel_110:)
		(trashcan sel_110:)
		(blotter sel_110:)
		(windowA sel_110:)
		(window1 sel_110:)
		(notice sel_311: 4 sel_110:)
		(aBulletin sel_311: 4 sel_110:)
		(herDesk sel_110:)
		(chair sel_110:)
		(hisDesk sel_110:)
		(if (!= gGSel_40 235)
			(southExitFeature sel_110:)
		else
			(gentsDoor sel_311: 0)
			(crod sel_311: 0)
			(notice sel_311: 0)
			(aBulletin sel_311: 0)
		)
		((ScriptID 1881 2)
			sel_1: 12
			sel_0: 95
			sel_549: 120
			sel_550: 0
		)
		((ScriptID 1896 7) sel_1: 220 sel_0: 80)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (global2 sel_146: sExitSouth))
		)
	)
	
	(method (sel_111)
		(gSel_608 sel_170:)
		(gLb2WH sel_81: global2)
		(gLb2DH sel_81: global2)
		(super sel_111:)
	)
	
	(method (sel_133 param1)
		(cond 
			(sel_365 (sel_365 sel_133: param1))
			(
				(and
					(& (param1 sel_31?) $0040)
					(== (gIconBar sel_207?) (gIconBar sel_228?))
					(!= (param1 sel_37?) 0)
				)
				(param1 sel_73: 1)
				(global2 sel_146: sStandUp)
			)
			((& (param1 sel_31?) $1000) (super sel_133: param1))
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(3 (global2 sel_146: sStandUp))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties
		sel_20 {sEnterNorth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_1: 160
					sel_0: 290
					sel_253: 1
					sel_312: MoveTo 160 180 self
				)
			)
			(1
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties
		sel_20 {sExitSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_253: 180 sel_312: MoveFwd 80 self)
			)
			(2 (global2 sel_399: 210))
		)
	)
)

(instance sDoTalking of Script
	(properties
		sel_20 {sDoTalking}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 21 0) sel_57: 261)
				(= sel_136 4)
			)
			(1
				(crod
					sel_3: 1
					sel_153: 273 152
					sel_146: 0
					sel_161: End self
				)
			)
			(2
				(gLb2Messager sel_295: 1 0 0 0 self)
			)
			(3 (crod sel_161: Beg self))
			(4 (global2 sel_399: 18))
		)
	)
)

(instance sCopyProBack of Script
	(properties
		sel_20 {sCopyProBack}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(crod sel_146: 0)
				(gGame sel_197: 0)
				(= sel_136 5)
			)
			(1
				(crod
					sel_3: 1
					sel_153: 273 152
					sel_146: 0
					sel_161: End self
				)
			)
			(2
				(gEgo sel_153: 160 160)
				(if (proc0_2 34)
					(gLb2Messager sel_295: 11 0 0 1 self)
				else
					(gLb2Messager sel_295: 11 0 0 2 self)
				)
			)
			(3 (crod sel_161: Beg self))
			(4
				(gGame sel_588:)
				(if (not (proc0_2 34))
					(= global145 3)
					(global2 sel_399: 99)
				)
				(crod sel_146: sTypeAwayCrod)
				(self sel_111:)
			)
		)
	)
)

(instance sSitAtDesk of Script
	(properties
		sel_20 {sSitAtDesk}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_326: 0)
				(= sel_136 1)
			)
			(1
				(if (proc0_2 30)
					(gGame sel_588:)
					(self sel_111:)
				else
					(= sel_136 1)
				)
			)
			(2
				(gLb2WH sel_129: global2)
				(gLb2DH sel_129: global2)
				(if (proc0_2 30)
					(= sel_136 1)
				else
					(gEgo sel_312: PolyPath 170 161 self)
				)
			)
			(3
				(gEgo
					sel_2: 231
					sel_155: 0
					sel_4: 10
					sel_153: 211 164
					sel_63: 11
					sel_161: End self
				)
				(proc0_3 30)
			)
			(4
				(southExitFeature sel_111:)
				(gentsDoor sel_311: 0)
				(crod sel_311: 0)
				(notice sel_311: 0)
				(aBulletin sel_311: 0)
				(= sel_137 1)
			)
			(5
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sStandUp of Script
	(properties
		sel_20 {sStandUp}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_137 1)
			)
			(1
				(if (proc0_2 30)
					(= sel_136 1)
				else
					(gGame sel_588:)
					(self sel_111:)
				)
			)
			(2
				(gEgo
					sel_2: 231
					sel_155: 0
					sel_153: 211 164
					sel_161: Beg self
				)
			)
			(3
				(gEgo sel_3: 6 sel_153: 173 164 sel_585: 830)
				(gLb2WH sel_81: global2)
				(gLb2DH sel_81: global2)
				(southExitFeature sel_110:)
				(proc0_4 30)
				(gentsDoor sel_311: 1 4)
				(crod sel_311: 1 4 2 6)
				(notice sel_311: 4)
				(aBulletin sel_311: 4)
				(= sel_136 1)
			)
			(4
				(gGame sel_588:)
				(gEgo sel_326: checkScaling)
				(self sel_111:)
			)
		)
	)
)

(instance sLookInset of Script
	(properties
		sel_20 {sLookInset}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_146: sSitAtDesk self)
			)
			(2
				(gLb2Messager sel_295: 24 1 0 0 self)
			)
			(3 (global2 sel_399: 235))
		)
	)
)

(instance sDigInTrash of Script
	(properties
		sel_20 {sDigInTrash}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_146: sSitAtDesk self)
			)
			(2
				(gEgo
					sel_2: 231
					sel_3: 2
					sel_153: 148 161
					sel_161: End self
				)
			)
			(3
				(gGame sel_588:)
				(if
				(and (not (gEgo sel_238: 4)) (not (gEgo sel_238: 22)))
					(global2 sel_422: inBaseball self)
					(gLb2Messager sel_295: 3 4 5)
				else
					(gLb2Messager sel_295: 3 4 6 0 self)
				)
			)
			(4
				(gGame sel_587:)
				(= sel_136 1)
			)
			(5 (gEgo sel_161: Beg self))
			(6
				(gEgo sel_155: 0 sel_4: 10 sel_153: 211 164)
				(= sel_136 4)
			)
			(7
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGentsDoor of Script
	(properties
		sel_20 {sGentsDoor}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(self sel_146: sStandUp self)
			)
			(1
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 41 155 self)
			)
			(2
				(crod sel_3: 3 sel_146: 0 sel_161: End self)
			)
			(3
				(crod sel_153: 277 153 sel_4: 0)
				(gLb2Messager sel_295: 2 4 0 0 self)
			)
			(4
				(gGame sel_588:)
				(crod sel_146: sTypeAwayCrod)
				(self sel_111:)
			)
		)
	)
)

(instance sTalkCrod of Script
	(properties
		sel_20 {sTalkCrod}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(crod
					sel_3: 1
					sel_153: 273 152
					sel_146: 0
					sel_161: End self
				)
			)
			(2
				(if local1
					(= local1 0)
					(gLb2Messager sel_295: 12 2 11 0 self)
				else
					(gLb2Messager sel_295: 12 2 12 0 self)
				)
			)
			(3 (crod sel_161: Beg self))
			(4
				(gGame sel_588:)
				(crod sel_146: sTypeAwayCrod)
				(self sel_111:)
			)
		)
	)
)

(instance sAskCrod of Script
	(properties
		sel_20 {sAskCrod}
	)
	
	(method (sel_144 theSel_29 &tmp temp0)
		(switch (= sel_29 theSel_29)
			(0
				(crod
					sel_3: 1
					sel_153: 273 152
					sel_146: 0
					sel_161: End self
				)
			)
			(1
				(switch (= temp0 (global2 sel_422: (ScriptID 20 0)))
					(1026
						(gLb2Messager sel_295: 12 6 41 0 self)
					)
					(257
						(gLb2Messager sel_295: 12 6 19 0 self)
					)
					(773
						(gLb2Messager sel_295: 12 6 35 0 self)
					)
					(273
						(gLb2Messager sel_295: 12 6 31 0 self)
					)
					(1027
						((ScriptID 21 0) sel_57: 264)
						((ScriptID 21 0) sel_57: 520)
						((ScriptID 21 0) sel_57: 260)
						((ScriptID 21 1) sel_57: 518)
						(gLb2Messager sel_295: 12 6 42 0 self)
					)
					(259
						(gLb2Messager sel_295: 12 6 21 0 self)
					)
					(770
						(gLb2Messager sel_295: 12 6 37 0 self)
					)
					(269
						(gLb2Messager sel_295: 12 6 28 0 self)
					)
					(769
						(gLb2Messager sel_295: 12 6 36 0 self)
					)
					(261
						(gLb2Messager sel_295: 12 6 45 0 self)
					)
					(780
						(gLb2Messager sel_295: 12 6 39 0 self)
					)
					(516
						(gLb2Messager sel_295: 12 6 16 0 self)
					)
					(1028
						(gLb2Messager sel_295: 12 6 44 0 self)
					)
					(518
						((ScriptID 21 0) sel_57: 264)
						((ScriptID 21 0) sel_57: 520)
						((ScriptID 21 1) sel_57: 518)
						(gLb2Messager sel_295: 12 6 47 0 self)
					)
					(265
						(gLb2Messager sel_295: 12 6 48 0 self)
					)
					(774
						(gLb2Messager sel_295: 12 6 33 0 self)
					)
					(262
						(gLb2Messager sel_295: 12 6 23 0 self)
					)
					(515
						(gLb2Messager sel_295: 12 6 15 0 self)
					)
					(517
						((ScriptID 21 0) sel_57: 259)
						((ScriptID 21 0) sel_57: 258)
						(gLb2Messager sel_295: 12 6 17 0 self)
					)
					(270
						(gLb2Messager sel_295: 12 6 29 0 self)
					)
					(519
						(gLb2Messager sel_295: 12 6 43 0 self)
					)
					(771
						(gLb2Messager sel_295: 12 6 32 0 self)
					)
					(513
						((ScriptID 21 0) sel_57: 257)
						(gLb2Messager sel_295: 12 6 13 0 self)
					)
					(260
						(gLb2Messager sel_295: 12 6 22 0 self)
					)
					(775
						(gLb2Messager sel_295: 12 6 34 0 self)
					)
					(258
						(gLb2Messager sel_295: 12 6 20 0 self)
					)
					(514
						(gLb2Messager sel_295: 12 6 14 0 self)
					)
					(772
						(gLb2Messager sel_295: 12 6 38 0 self)
					)
					(520
						(gLb2Messager sel_295: 12 6 18 0 self)
					)
					(263
						(gLb2Messager sel_295: 12 6 24 0 self)
					)
					(271
						((ScriptID 21 0) sel_57: 258)
						(gLb2Messager sel_295: 12 6 30 0 self)
					)
					(266
						(gLb2Messager sel_295: 12 6 27 0 self)
					)
					(264
						(gLb2Messager sel_295: 12 6 25 0 self)
					)
					(else 
						(if (== -1 temp0)
							(= sel_136 1)
						else
							(gLb2Messager sel_295: 12 6 26 0 self)
						)
					)
				)
			)
			(2 (crod sel_161: Beg self))
			(3
				(gGame sel_588:)
				(crod sel_146: sTypeAwayCrod)
				(self sel_111:)
			)
		)
	)
)

(instance sTypeAwayCrod of Script
	(properties
		sel_20 {sTypeAwayCrod}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(crod sel_153: 273 152 sel_155: 4 sel_161: RandCycle)
				(= sel_137 (Random 5 10))
			)
			(1 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sMoveIt of Script
	(properties
		sel_20 {sMoveIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(person1
					sel_155: 1
					sel_161: Walk
					sel_153: 330 110
					sel_312: MoveTo 228 117 self
				)
			)
			(1 (= sel_137 (Random 4 8)))
			(2
				(person1 sel_155: 0 sel_312: MoveTo 330 117 self)
			)
			(3 (= sel_137 (Random 8 12)))
			(4 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance sMoveIt2 of Script
	(properties
		sel_20 {sMoveIt2}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 (Random 4 9)))
			(1
				(person2
					sel_155: 3
					sel_153: 330 108
					sel_161: Walk
					sel_312: MoveTo 241 108 self
				)
			)
			(2
				(person2 sel_155: 4 sel_244: 8 sel_161: RandCycle)
				(= sel_137 (Random 4 7))
			)
			(3
				(person2 sel_161: 0)
				(= sel_137 (Random 1 3))
			)
			(4
				(person2
					sel_155: 2
					sel_153: 241 108
					sel_244: 6
					sel_161: Walk
					sel_312: MoveTo 330 108 self
				)
			)
			(5 (= sel_137 (Random 4 8)))
			(6 (= sel_29 -1) (= sel_136 1))
		)
	)
)

(instance crod of Prop
	(properties
		sel_20 {crod}
		sel_1 273
		sel_0 152
		sel_213 12
		sel_303 242
		sel_304 164
		sel_2 232
		sel_3 4
	)
	
	(method (sel_300 param1)
		(switch param1
			(2 (global2 sel_146: sTalkCrod))
			(6 (global2 sel_146: sAskCrod))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance personS of Prop
	(properties
		sel_20 {personS}
		sel_1 152
		sel_0 139
		sel_213 13
		sel_2 233
		sel_3 5
	)
	
	(method (sel_300 param1)
		(switch param1
			(2
				(if local2
					(= local2 0)
					(gLb2Messager sel_295: 13 2 11)
				else
					(gLb2Messager sel_295: 13 2 12)
				)
			)
			(6
				(gLb2Messager sel_295: 13 6 46)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance personT of Prop
	(properties
		sel_20 {personT}
		sel_1 85
		sel_0 154
		sel_213 14
		sel_2 233
		sel_3 6
		sel_14 4096
	)
	
	(method (sel_300 param1)
		(switch param1
			(6
				(gLb2Messager sel_295: 13 6 46)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance person1 of Actor
	(properties
		sel_20 {person1}
		sel_1 330
		sel_0 110
		sel_213 15
		sel_2 233
		sel_3 1
	)
)

(instance person2 of Actor
	(properties
		sel_20 {person2}
		sel_1 330
		sel_0 118
		sel_213 15
		sel_2 233
		sel_3 3
		sel_60 6
		sel_14 16
	)
)

(instance inBaseball of Inset
	(properties
		sel_20 {inBaseball}
		sel_2 238
		sel_1 144
		sel_0 121
		sel_570 1
		sel_214 15
		sel_213 1
	)
	
	(method (sel_110)
		(gLb2WH sel_81: global2)
		(gLb2DH sel_81: global2)
		(super sel_110: &rest)
	)
	
	(method (sel_111)
		(super sel_111: &rest)
		(gLb2WH sel_129: global2)
		(gLb2DH sel_129: global2)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 1 1 0 0 0 15)
			)
			(4
				((ScriptID 21 0) sel_57: 773)
				(inBaseball sel_111:)
				(gEgo sel_350: 4)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance checkScaling of Code
	(properties
		sel_20 {checkScaling}
	)
	
	(method (sel_57)
		(cond 
			((> (gEgo sel_0?) 165) (gEgo sel_2: 829))
			((gEgo sel_349?) (gEgo sel_299: 0))
			(else (gEgo sel_2: 830))
		)
	)
)

(instance trashcan of Feature
	(properties
		sel_20 {trashcan}
		sel_1 164
		sel_0 146
		sel_213 3
		sel_6 140
		sel_7 157
		sel_8 152
		sel_9 172
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sDigInTrash)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance blotter of Feature
	(properties
		sel_20 {blotter}
		sel_1 194
		sel_0 117
		sel_213 4
		sel_6 115
		sel_7 180
		sel_8 120
		sel_9 208
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sLookInset)
			)
			(1
				(global2 sel_146: sLookInset)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance gentsDoor of Feature
	(properties
		sel_20 {gentsDoor}
		sel_1 19
		sel_0 115
		sel_213 2
		sel_6 78
		sel_8 152
		sel_9 39
		sel_301 40
		sel_303 41
		sel_304 155
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sGentsDoor)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance windowA of Feature
	(properties
		sel_20 {windowA}
		sel_1 123
		sel_0 95
		sel_213 5
		sel_6 85
		sel_7 109
		sel_8 105
		sel_9 138
		sel_301 40
	)
)

(instance window1 of Feature
	(properties
		sel_20 {window1}
		sel_1 176
		sel_0 93
		sel_213 5
		sel_6 85
		sel_7 167
		sel_8 101
		sel_9 185
		sel_301 40
	)
)

(instance aBulletin of Feature
	(properties
		sel_20 {aBulletin}
		sel_1 61
		sel_0 98
		sel_213 6
		sel_6 82
		sel_7 47
		sel_8 114
		sel_9 76
		sel_301 40
		sel_303 83
		sel_304 161
	)
	
	(method (sel_300 param1)
		(notice sel_300: param1 &rest)
	)
)

(instance notice of Feature
	(properties
		sel_20 {notice}
		sel_1 56
		sel_0 99
		sel_213 7
		sel_6 85
		sel_7 52
		sel_8 94
		sel_9 60
		sel_303 83
		sel_304 161
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (proc0_2 30)
					(gLb2Messager sel_295: 7 1 40)
				else
					(switch local0
						(1
							(gLb2Messager sel_295: 7 1 11)
							(++ local0)
						)
						(2
							(gLb2Messager sel_295: 7 1 8)
							(++ local0)
						)
						(3
							(gLb2Messager sel_295: 7 1 9)
							(++ local0)
						)
						(else 
							(gLb2Messager sel_295: 7 1 10)
							(= local0 1)
						)
					)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		sel_20 {chair}
		sel_0 138
		sel_213 24
		sel_6 119
		sel_7 179
		sel_8 158
		sel_9 210
	)
	
	(method (sel_300 param1)
		(herDesk sel_300: param1 &rest)
	)
)

(instance herDesk of Feature
	(properties
		sel_20 {herDesk}
		sel_0 145
		sel_213 24
		sel_302 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sLookInset)
			)
			(1
				(global2 sel_146: sLookInset)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance hisDesk of Feature
	(properties
		sel_20 {hisDesk}
		sel_0 145
		sel_213 17
		sel_302 8192
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_8 189
		sel_9 320
		sel_33 11
		sel_583 3
		sel_213 16
	)
)

(instance Laura of Talker
	(properties
		sel_20 {Laura}
		sel_1 12
		sel_0 87
		sel_2 1231
		sel_3 3
		sel_537 160
		sel_26 15
		sel_549 120
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: tLauraBust 0 tLauraMouth &rest)
	)
)

(instance tLauraMouth of Prop
	(properties
		sel_20 {tLauraMouth}
		sel_6 49
		sel_7 55
		sel_2 1231
	)
)

(instance tLauraBust of Prop
	(properties
		sel_20 {tLauraBust}
		sel_6 10
		sel_7 10
		sel_2 1231
		sel_3 1
	)
)

(instance Crodfoller of Talker
	(properties
		sel_20 {Crodfoller}
		sel_1 220
		sel_0 60
		sel_2 1230
		sel_3 3
		sel_537 150
		sel_26 15
		sel_549 -205
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: tCrodBust tCrodEyes tCrodMouth &rest)
	)
)

(instance tCrodMouth of Prop
	(properties
		sel_20 {tCrodMouth}
		sel_6 39
		sel_7 20
		sel_2 1230
	)
)

(instance tCrodEyes of Prop
	(properties
		sel_20 {tCrodEyes}
		sel_6 25
		sel_7 21
		sel_2 1230
		sel_3 2
	)
)

(instance tCrodBust of Prop
	(properties
		sel_20 {tCrodBust}
		sel_2 1230
		sel_3 1
	)
)

(instance MiscPeople of Narrator
	(properties
		sel_20 {MiscPeople}
		sel_1 10
		sel_0 10
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)

(instance MidForground of Narrator
	(properties
		sel_20 {MidForground}
		sel_1 100
		sel_0 50
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)

(instance ManWriting of Narrator
	(properties
		sel_20 {ManWriting}
		sel_1 50
		sel_0 50
		sel_537 150
		sel_26 15
	)
	
	(method (sel_110)
		(= sel_30 gSel_30)
		(super sel_110: &rest)
	)
)
