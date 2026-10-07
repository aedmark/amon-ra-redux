;;; Sierra Script 1.0 - (do not remove this comment)
(script# 490)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use PChase)
(use Scaler)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm490 0
)

(local
	local0
	local1
)
(instance rm490 of LBRoom
	(properties
		sel_20 {rm490}
		sel_213 5
		sel_408 490
		sel_410 440
		sel_411 440
		sel_412 440
		sel_107 150
		sel_108 100
	)
	
	(method (sel_110)
		(proc958_0 128 491 424 423 818 426 831)
		(proc958_0 132 490 1)
		(gEgo
			sel_110:
			sel_585: (if (== global123 5) 426 else 831)
			sel_320: Scaler 160 40 190 100
		)
		(if (== global123 5)
			(self sel_414: 94)
			(global2 sel_259: (List sel_109:))
			((ScriptID 2490 0) sel_57: (global2 sel_259?))
		else
			(self sel_414: 90)
		)
		(switch gGSel_40
			(sel_411
				(self sel_146: sEnterSouth)
			)
			(else 
				(gEgo sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (proc0_2 143)
			(if (proc0_2 37)
				(zHead
					sel_3: 2
					sel_4: 1
					sel_1: 231
					sel_0: 133
					sel_311: 4 1 8
					sel_110:
					sel_63: 10
					sel_303: 213
					sel_304: 135
				)
				(self
					sel_395:
						(= local0
							((Polygon sel_109:)
								sel_31: 2
								sel_110: 252 133 236 143 201 132 227 130
								sel_117:
							)
						)
				)
			else
				(zHead sel_311: 4 1 8 sel_110:)
			)
		)
		(southExitFeature sel_110:)
		(westExitFeature sel_110:)
		(eastExitFeature sel_110:)
		(genericHead sel_110:)
		(floor sel_110:)
		(if (== global123 5)
			(oriley
				sel_110:
				sel_161: Walk
				sel_320: Scaler 160 40 190 80
			)
		)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (global2 sel_146: sExitSouth))
		)
	)
	
	(method (sel_111)
		(DisposeScript 2490)
		(super sel_111:)
	)
	
	(method (sel_399)
		(if (IsObject local0)
			((global2 sel_259?) sel_81: local0)
			(local0 sel_111:)
		)
		(super sel_399: &rest)
	)
	
	(method (sel_403)
		(if (== global123 5)
			(if (global2 sel_142?)
				((global2 sel_142?) sel_65: sKillHer)
			else
				(global2 sel_146: sKillHer)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		sel_20 {sEnterSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_153: 320 190
					sel_253: 315
					sel_312: MoveFwd 40 self
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
				(cond 
					((> (gEgo sel_1?) 310) (gEgo sel_253: 90))
					((< (gEgo sel_1?) 20) (gEgo sel_253: 270))
					(else (gEgo sel_253: 180))
				)
				(gEgo sel_312: MoveFwd 100 self)
			)
			(2 (global2 sel_399: 440))
		)
	)
)

(instance sOhNoMurder of Script
	(properties
		sel_20 {sOhNoMurder}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(if (not (proc0_10 -20222))
					((ScriptID 22 0) sel_57: -20222 self)
				else
					(= sel_136 1)
				)
			)
			(2
				(WrapMusic sel_168: 1)
				(sWrapMusic sel_110: -1 1 6)
				(= sel_136 3)
			)
			(3
				(global2 sel_422: inHead)
				(= sel_137 3)
			)
			(4
				(inHead sel_422: inReaction)
				(noise sel_40: 82 sel_99: 5 sel_3: 1 sel_39: self)
				(= local1 1)
			)
			(5
				(inReaction sel_111:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sKillHer of Script
	(properties
		sel_20 {sKillHer}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 186 150 self)
			)
			(2
				(gSel_608 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(oriley sel_53: 4 sel_244: 4 sel_312: PChase gEgo 25 self)
			)
			(3
				(proc0_5 gEgo oriley)
				(oriley sel_2: 424 sel_4: 0 sel_161: End self)
			)
			(4
				(noise sel_40: 80 sel_99: 5 sel_3: 1 sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(5
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sGetHead of Script
	(properties
		sel_20 {sGetHead}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(global2
					sel_395:
						(= local0
							((Polygon sel_109:)
								sel_31: 2
								sel_110: 252 133 236 143 201 132 227 130
								sel_117:
							)
						)
				)
				(zHead sel_3: 1 sel_161: End self)
			)
			(2
				(zHead
					sel_155: 2
					sel_4: 2
					sel_153: 211 131
					sel_161: End self
				)
				(noise sel_40: 490 sel_99: 5 sel_39:)
			)
			(3
				(zHead sel_161: End self sel_312: MoveTo 231 133)
			)
			(4 (zHead sel_161: CT 1 1 self))
			(5
				(proc0_3 37)
				(zHead sel_303: 213 sel_304: 135 sel_161: 0 sel_63: 10)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sTheyComeIn of Script
	(properties
		sel_20 {sTheyComeIn}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(sWrapMusic sel_111: 1)
				(= sel_136 1)
			)
			(1
				(localSound sel_111:)
				((ScriptID 32 0)
					sel_620: 490
					sel_110:
					sel_2: 814
					sel_1: 253
					sel_0: 240
					sel_161: Walk
					sel_312: MoveTo 249 145 self
				)
				(= sel_141 ((ScriptID 90 3) sel_620?))
				((ScriptID 90 3)
					sel_182: 490
					sel_2: 818
					sel_1: 280
					sel_0: 240
					sel_312: MoveTo 290 141 self
				)
				(gGameMusic2 sel_40: 350 sel_99: 1 sel_3: -1 sel_39:)
			)
			(2 0)
			(3
				((ScriptID 32 0) sel_161: StopWalk -1)
				((ScriptID 90 3) sel_3: 7)
				(= sel_136 1)
			)
			(4
				(proc0_5 gEgo (ScriptID 90 3))
				(= sel_136 5)
			)
			(5
				(gLb2Messager sel_295: 1 0 1 0 self 1490)
			)
			(6
				((ScriptID 32 0)
					sel_161: Walk
					sel_312: PolyPath 275 300 self
				)
				((ScriptID 90 3) sel_312: PolyPath 302 300 self)
			)
			(7
				0
				(gGameMusic2 sel_170:)
				(WrapMusic sel_168: 0)
				((ScriptID 90 3) sel_182: sel_141)
				(gGame sel_588:)
				(gGame sel_87: 1 144)
				(proc0_3 36)
				(self sel_111:)
			)
		)
	)
)

(instance sExamineHead of Script
	(properties
		sel_20 {sExamineHead}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(WrapMusic sel_168: 1)
				(if (not (== global123 5)) (mExamineMusic sel_39:))
				(global2 sel_422: inHead self)
			)
			(1
				(mExamineMusic sel_111:)
				(WrapMusic sel_168: 0)
				(self sel_111:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 150
		sel_0 300
		sel_2 423
	)
)

(instance zHead of Actor
	(properties
		sel_20 {zHead}
		sel_1 190
		sel_0 87
		sel_213 1
		sel_303 189
		sel_304 135
		sel_2 491
		sel_3 1
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(if (== global123 5)
			(gLb2Messager sel_295: 36 0 0 0)
		else
			(switch param1
				(1
					(if (proc0_2 36)
						(global2 sel_146: sExamineHead)
					else
						(global2 sel_146: sOhNoMurder)
					)
				)
				(8 (self sel_300: 1))
				(4
					(cond 
						((proc0_2 37) (gLb2Messager sel_295: 1 4 1))
						((not (proc0_2 36)) (gLb2Messager sel_295: 1 4 2))
						(else (global2 sel_146: sGetHead))
					)
				)
				(else 
					(super sel_300: param1 &rest)
				)
			)
		)
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_302 16386
	)
)

(instance inHead of Inset
	(properties
		sel_20 {inHead}
		sel_408 495
		sel_560 1
		sel_570 1
		sel_213 6
	)
	
	(method (sel_110)
		(gEgo sel_102:)
		(zHead sel_102:)
		(super sel_110: &rest)
		(gGame sel_87: 1 144)
		(proc0_8 1)
	)
	
	(method (sel_111)
		(gEgo sel_216:)
		(zHead sel_216:)
		(proc0_8 0)
		(if (not (proc0_2 36)) (global2 sel_146: sTheyComeIn))
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(inHead sel_111:)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inReaction of Inset
	(properties
		sel_20 {inReaction}
		sel_408 555
		sel_560 1
		sel_570 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 184
		sel_8 189
		sel_9 319
		sel_33 11
		sel_583 3
		sel_213 35
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		sel_20 {eastExitFeature}
		sel_6 133
		sel_7 314
		sel_8 189
		sel_9 319
		sel_33 14
		sel_583 2
		sel_213 35
	)
)

(instance westExitFeature of ExitFeature
	(properties
		sel_20 {westExitFeature}
		sel_6 147
		sel_8 189
		sel_9 5
		sel_33 12
		sel_583 3
		sel_213 35
	)
)

(instance genericHead of Feature
	(properties
		sel_20 {genericHead}
		sel_0 5
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (gLb2Messager sel_295: 13 4))
			(8 (gLb2Messager sel_295: 13 8))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
	
	(method (sel_218 param1)
		(if (super sel_218: param1)
			(cond 
				(
					(and
						(<= 59 gSel_1)
						(<= gSel_1 74)
						(<= 68 gSel_0)
						(<= gSel_0 82)
					)
					(= sel_213 2)
				)
				(
					(and
						(<= 39 gSel_1)
						(<= gSel_1 56)
						(<= 47 gSel_0)
						(<= gSel_0 65)
					)
					(= sel_213 9)
				)
				(
					(and
						(<= 136 gSel_1)
						(<= gSel_1 147)
						(<= 87 gSel_0)
						(<= gSel_0 99)
					)
					(= sel_213 19)
				)
				(
					(and
						(<= 152 gSel_1)
						(<= gSel_1 163)
						(<= 91 gSel_0)
						(<= gSel_0 101)
					)
					(= sel_213 20)
				)
				(
					(and
						(<= 63 gSel_1)
						(<= gSel_1 80)
						(<= 108 gSel_0)
						(<= gSel_0 125)
					)
					(= sel_213 14)
				)
				(
					(and
						(<= 276 gSel_1)
						(<= gSel_1 294)
						(<= 74 gSel_0)
						(<= gSel_0 91)
					)
					(= sel_213 31)
				)
				(
					(and
						(<= 182 gSel_1)
						(<= gSel_1 195)
						(<= 112 gSel_0)
						(<= gSel_0 124)
					)
					(= sel_213 27)
				)
				(
					(and
						(<= 146 gSel_1)
						(<= gSel_1 152)
						(<= 101 gSel_0)
						(<= gSel_0 113)
					)
					(= sel_213 3)
				)
				(
					(and
						(<= 88 gSel_1)
						(<= gSel_1 102)
						(<= 107 gSel_0)
						(<= gSel_0 122)
					)
					(= sel_213 15)
				)
				(
					(and
						(<= 133 gSel_1)
						(<= gSel_1 146)
						(<= 68 gSel_0)
						(<= gSel_0 84)
					)
					(= sel_213 4)
				)
				(
					(and
						(<= 74 gSel_1)
						(<= gSel_1 91)
						(<= 61 gSel_0)
						(<= gSel_0 76)
					)
					(= sel_213 16)
				)
				(
					(and
						(<= 139 gSel_1)
						(<= gSel_1 150)
						(<= 113 gSel_0)
						(<= gSel_0 125)
					)
					(= sel_213 10)
				)
				(
					(and
						(<= 177 gSel_1)
						(<= gSel_1 184)
						(<= 85 gSel_0)
						(<= gSel_0 96)
					)
					(= sel_213 26)
				)
				(
					(and
						(<= 243 gSel_1)
						(<= gSel_1 262)
						(<= 75 gSel_0)
						(<= gSel_0 93)
					)
					(= sel_213 30)
				)
				(
					(and
						(<= 89 gSel_1)
						(<= gSel_1 101)
						(<= 53 gSel_0)
						(<= gSel_0 66)
					)
					(= sel_213 17)
				)
				(
					(and
						(<= 165 gSel_1)
						(<= gSel_1 176)
						(<= 93 gSel_0)
						(<= gSel_0 103)
					)
					(= sel_213 23)
				)
				(
					(and
						(<= 185 gSel_1)
						(<= gSel_1 195)
						(<= 89 gSel_0)
						(<= gSel_0 99)
					)
					(= sel_213 25)
				)
				(
					(and
						(<= 279 gSel_1)
						(<= gSel_1 294)
						(<= 102 gSel_0)
						(<= gSel_0 119)
					)
					(= sel_213 24)
				)
				(
					(and
						(<= 153 gSel_1)
						(<= gSel_1 163)
						(<= 104 gSel_0)
						(<= gSel_0 114)
					)
					(= sel_213 18)
				)
				(
					(and
						(<= 312 gSel_1)
						(<= gSel_1 319)
						(<= 73 gSel_0)
						(<= gSel_0 88)
					)
					(= sel_213 29)
				)
				(
					(and
						(<= 68 gSel_1)
						(<= gSel_1 88)
						(<= 88 gSel_0)
						(<= gSel_0 104)
					)
					(= sel_213 12)
				)
				(
					(and
						(<= 245 gSel_1)
						(<= gSel_1 261)
						(<= 101 gSel_0)
						(<= gSel_0 117)
					)
					(= sel_213 28)
				)
				(
					(and
						(<= 148 gSel_1)
						(<= gSel_1 156)
						(<= 78 gSel_0)
						(<= gSel_0 89)
					)
					(= sel_213 21)
				)
				(
					(and
						(<= 159 gSel_1)
						(<= gSel_1 169)
						(<= 81 gSel_0)
						(<= gSel_0 93)
					)
					(= sel_213 22)
				)
				(
					(and
						(<= 134 gSel_1)
						(<= gSel_1 145)
						(<= 99 gSel_0)
						(<= gSel_0 112)
					)
					(= sel_213 11)
				)
				(
					(and
						(<= 313 gSel_1)
						(<= gSel_1 319)
						(<= 103 gSel_0)
						(<= gSel_0 118)
					)
					(= sel_213 33)
				)
				(
					(and
						(<= 178 gSel_1)
						(<= gSel_1 188)
						(<= 97 gSel_0)
						(<= gSel_0 109)
					)
					(= sel_213 32)
				)
			)
		)
	)
)

(instance noise of Sound
	(properties
		sel_20 {noise}
		sel_99 1
	)
)

(instance mExamineMusic of Sound
	(properties
		sel_20 {mExamineMusic}
		sel_99 1
		sel_40 6
		sel_3 -1
	)
)

(instance sWrapMusic of WrapMusic
	(properties
		sel_20 {sWrapMusic}
	)
	
	(method (sel_110)
		(= sel_608 localSound)
		(super sel_110: &rest)
	)
)

(instance localSound of Sound
	(properties
		sel_20 {localSound}
	)
)
