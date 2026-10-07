;;; Sierra Script 1.0 - (do not remove this comment)
(script# 420)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use Inset)
(use PChase)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use Timer)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm420 0
)

(local
	local0
	theGLb2DoVerbCode
)
(instance rm420 of LBRoom
	(properties
		sel_20 {rm420}
		sel_408 420
		sel_409 350
		sel_410 430
		sel_412 500
		sel_107 0
	)
	
	(method (sel_110)
		(gGame sel_587:)
		(proc958_0 128 420 423 424 426 831)
		(if
			(or
				(> global123 3)
				(and (== global123 3) (proc0_10 8512 1))
			)
			(proc958_0 129 556 429)
			(proc958_0 132 3 80 6 84)
		)
		(Load rsSOUND 19)
		(gEgo
			sel_110:
			sel_585: (if (== global123 5) 426 else 831)
			sel_320: Scaler 100 0 190 0
		)
		(if (== global123 5)
			(if (proc0_2 34)
				(gGame sel_588:)
				(gSel_608 sel_40: 16 sel_99: 1 sel_155: -1 sel_39:)
				(self sel_414: 94)
				(global2 sel_259: (List sel_109:))
				((ScriptID 2420 0) sel_57: (global2 sel_259?))
				(oriley sel_110: sel_320: 165 sel_161: Walk)
			else
				(self sel_146: sCopyFail)
			)
		else
			(self sel_414: 90)
		)
		(switch gGSel_40
			(sel_409
				(self sel_146: sEnterNorth)
			)
			(sel_410
				(if
					(and
						(or
							(> global123 3)
							(and (== global123 3) (proc0_10 8512 1))
						)
						(not (proc0_2 67))
					)
					(self sel_146: sLookitDeadErnie 0 1)
				else
					(gGame sel_588:)
				)
				(gEgo sel_0: 187)
			)
			(sel_412
				(self sel_146: sEnterWest)
			)
			(18
				(gEgo sel_153: 264 164)
				(gEgo sel_253: 180)
			)
			(else 
				(gEgo sel_153: 185 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(= local0
			(cond 
				((< global87 5) 85)
				((< global87 10) 60)
				((<= global87 15) 35)
			)
		)
		(if (not (HaveMouse)) (= local0 (* 2 local0)))
		(if (and (== global123 5) (!= sel_142 sCopyFail))
			(oRileyTimer sel_163: 300 oRileyTimer)
		)
		(if
			(or
				(> global123 3)
				(and (== global123 3) (proc0_10 8512 1))
			)
			(ernie sel_317: sel_311: 4 1 8)
		)
		(southExitFeature sel_110:)
		(wall sel_110:)
		(floor sel_110:)
		(tuskSupport sel_110:)
		(dinoSkeleton sel_110:)
		(skull sel_110:)
		(leftPic sel_110:)
		(rightPic sel_110:)
		(mastodon sel_110:)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (self sel_146: sExitNorth))
			((proc0_1 gEgo 4)
				(gGame sel_587:)
				(gEgo sel_349: 4)
				(global2 sel_399: (global2 sel_412?))
			)
		)
	)
	
	(method (sel_399 param1)
		(switch global123
			(2
				(if (== param1 350)
					(if (gGameMusic2 sel_90?)
						(gGameMusic2 sel_167:)
						(gSel_608 sel_168: 0)
					)
					(gSel_608 sel_170: 127 5 5 0)
				)
			)
			(3
				(if
					(and
						(== param1 430)
						(proc0_10 -20222 1)
						(not (proc0_2 72))
					)
					(= param1 435)
				)
			)
			(5
				((ScriptID 94 1) sel_162: (ScriptID 94 1) local0)
				(DisposeScript 2420)
			)
		)
		(super sel_399: param1)
	)
	
	(method (sel_403)
		(if (== global123 5)
			(if
				(and
					(global2 sel_142?)
					(not (== (global2 sel_142?) sDie))
				)
				((global2 sel_142?) sel_65: sDie)
			else
				(global2 sel_146: sDie)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_0 155
		sel_2 423
	)
	
	(method (sel_145)
		(if (not (global2 sel_142?))
			(gGame sel_587:)
			(global2 sel_146: sDie)
		)
	)
)

(instance ernie of View
	(properties
		sel_20 {ernie}
		sel_1 175
		sel_0 189
		sel_82 71
		sel_213 9
		sel_303 199
		sel_304 180
		sel_2 420
		sel_60 15
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(gGame sel_87: 1 158)
		(switch param1
			(1
				(if (== global123 5)
					(gLb2Messager sel_295: 27)
				else
					(gIconBar sel_233: 7)
					(global2 sel_146: sDeadErnie)
				)
			)
			(8 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance wall of Feature
	(properties
		sel_20 {wall}
		sel_0 1
		sel_213 1
		sel_301 40
		sel_302 512
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_0 1
		sel_213 2
		sel_301 40
		sel_302 1024
	)
)

(instance tuskSupport of Feature
	(properties
		sel_20 {tuskSupport}
		sel_0 1
		sel_213 3
		sel_301 40
		sel_302 128
	)
)

(instance dinoSkeleton of Feature
	(properties
		sel_20 {dinoSkeleton}
		sel_0 1
		sel_213 4
		sel_301 40
		sel_302 64
	)
)

(instance skull of Feature
	(properties
		sel_20 {skull}
		sel_0 1
		sel_213 5
		sel_301 40
		sel_302 8
	)
)

(instance leftPic of Feature
	(properties
		sel_20 {leftPic}
		sel_0 1
		sel_213 6
		sel_301 40
		sel_302 32
	)
)

(instance rightPic of Feature
	(properties
		sel_20 {rightPic}
		sel_0 1
		sel_213 7
		sel_301 40
		sel_302 16
	)
)

(instance mastodon of Feature
	(properties
		sel_20 {mastodon}
		sel_0 1
		sel_213 8
		sel_301 40
		sel_302 260
	)
)

(instance inDeadErnie of Inset
	(properties
		sel_20 {inDeadErnie}
		sel_408 429
		sel_560 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(= theGLb2DoVerbCode gLb2DoVerbCode)
		(= gLb2DoVerbCode exitDoVerbCode)
		(proc0_8 1)
		(gLb2WH sel_129: self)
		(feSuspenders sel_110:)
		(feShirt sel_110:)
		(feTusks sel_110:)
		(feRtArm sel_110:)
		(feLtArm sel_110:)
		(feSupport sel_110:)
		(feShoe sel_110:)
		(fePants sel_110:)
		(feEye sel_110:)
		(feSkull sel_110:)
		(feEar sel_110:)
		(feNeck sel_110:)
		(feMouth sel_110:)
		(feHead sel_110:)
	)
	
	(method (sel_111)
		(= gLb2DoVerbCode theGLb2DoVerbCode)
		(gLb2WH sel_81: self)
		(gIconBar sel_177: 7)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13 (inDeadErnie sel_111:))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance exitDoVerbCode of Code
	(properties
		sel_20 {exitDoVerbCode}
	)
	
	(method (sel_57 param1 param2)
		(if (== param1 13)
			(inDeadErnie sel_111:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance feSuspenders of Feature
	(properties
		sel_20 {feSuspenders}
		sel_0 1
		sel_213 11
		sel_301 40
		sel_302 16384
	)
)

(instance feShirt of Feature
	(properties
		sel_20 {feShirt}
		sel_0 1
		sel_213 12
		sel_301 40
		sel_302 8192
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (not (gEgo sel_238: 25))
					(inDeadErnie sel_422: inWartHairs)
				else
					(super sel_300: param1)
				)
			)
			(8
				(if (not (gEgo sel_238: 25))
					(inDeadErnie sel_422: inWartHairs)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance feTusks of Feature
	(properties
		sel_20 {feTusks}
		sel_0 1
		sel_213 13
		sel_301 40
		sel_302 4096
	)
)

(instance feRtArm of Feature
	(properties
		sel_20 {feRtArm}
		sel_0 1
		sel_213 14
		sel_301 40
		sel_302 2048
	)
)

(instance feLtArm of Feature
	(properties
		sel_20 {feLtArm}
		sel_0 1
		sel_213 15
		sel_301 40
		sel_302 1024
	)
)

(instance feSupport of Feature
	(properties
		sel_20 {feSupport}
		sel_0 1
		sel_213 16
		sel_301 40
		sel_302 512
	)
)

(instance feShoe of Feature
	(properties
		sel_20 {feShoe}
		sel_0 1
		sel_213 17
		sel_301 40
		sel_302 256
	)
)

(instance fePants of Feature
	(properties
		sel_20 {fePants}
		sel_0 1
		sel_213 18
		sel_301 40
		sel_302 128
	)
)

(instance feEye of Feature
	(properties
		sel_20 {feEye}
		sel_0 1
		sel_213 19
		sel_301 40
		sel_302 64
	)
)

(instance feSkull of Feature
	(properties
		sel_20 {feSkull}
		sel_0 1
		sel_213 20
		sel_301 40
		sel_302 32
	)
)

(instance feEar of Feature
	(properties
		sel_20 {feEar}
		sel_0 1
		sel_213 21
		sel_301 40
		sel_302 16
	)
)

(instance feNeck of Feature
	(properties
		sel_20 {feNeck}
		sel_0 1
		sel_213 22
		sel_301 40
		sel_302 8
	)
)

(instance feMouth of Feature
	(properties
		sel_20 {feMouth}
		sel_0 1
		sel_213 23
		sel_301 40
		sel_302 4
	)
)

(instance feHead of Feature
	(properties
		sel_20 {feHead}
		sel_0 1
		sel_213 24
		sel_301 40
		sel_302 2
	)
)

(instance inWartHairs of Inset
	(properties
		sel_20 {inWartHairs}
		sel_2 420
		sel_3 1
		sel_1 126
		sel_0 57
		sel_570 1
		sel_213 10
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(gGame sel_87: 1 159)
					(gEgo sel_350: 25)
					((ScriptID 21 0) sel_57: 794)
					(self sel_111:)
					(return 1)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance sExitNorth of Script
	(properties
		sel_20 {sExitNorth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 0 sel_312: MoveFwd 20 self)
			)
			(1
				(global2 sel_399: (global2 sel_409?))
			)
		)
	)
)

(instance sLookitDeadErnie of Script
	(properties
		sel_20 {sLookitDeadErnie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if sel_141
					(gEgo sel_312: PolyPath 280 185 self)
				else
					(= sel_136 1)
				)
			)
			(1
				(proc0_5 gEgo ernie)
				(= sel_139 120)
			)
			(2
				(ernie sel_300: 1)
				(if sel_141 (gGame sel_588:))
				(self sel_111:)
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
				(gEgo
					sel_153: 300 140
					sel_253: 180
					sel_312: MoveFwd 20 self
				)
				(if
				(and (== global123 2) (not (proc0_10 -32480 1)))
					((ScriptID 32 0)
						sel_110:
						sel_2: 814
						sel_620: gSel_40
						sel_153: 154 179
						sel_155: 8
						sel_156: 6
						sel_213: 1
					)
					(gSel_608 sel_168:)
					(gGameMusic2 sel_40: 19 sel_99: 1 sel_155: 1 sel_39:)
				)
			)
			(1
				(cond 
					(
					(and (== global123 2) (not (proc0_10 -32480 1))) (global2 sel_146: sHeimlichShoos))
					(
						(and
							(or
								(> global123 3)
								(and (== global123 3) (proc0_10 8512 1))
							)
							(not (proc0_2 67))
						)
						(self sel_146: sLookitDeadErnie self)
					)
					(else (= sel_136 1))
				)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties
		sel_20 {sEnterWest}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo
					sel_153: 2 150
					sel_253: 135
					sel_312: MoveFwd 20 self
				)
			)
			(1
				(if
					(and
						(or
							(> global123 3)
							(and (== global123 3) (proc0_10 8512 1))
						)
						(not (proc0_2 67))
					)
					(self sel_146: sLookitDeadErnie self)
				else
					(= sel_136 1)
				)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sDeadErnie of Script
	(properties
		sel_20 {sDeadErnie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(WrapMusic sel_168:)
				(if (proc0_2 67)
					(fooSound sel_40: 6 sel_3: -1 sel_99: 1 sel_39:)
					(= sel_136 1)
				else
					(proc0_3 67)
					(gSel_561 sel_119: 102)
					(DrawPic 556)
					(gSel_563 sel_119: 111 sel_125:)
					(wrapMusic sel_110: -1 3 6)
					(sFX sel_40: 84 sel_99: 5 sel_3: 1 sel_39:)
					(= sel_139 180)
				)
			)
			(1
				(global2 sel_422: inDeadErnie self)
			)
			(2
				(gSel_561 sel_119: 216)
				(ernie sel_317:)
				(= sel_136 2)
			)
			(3
				(fooSound sel_170: 0 12 30 1)
				(if (gSounds sel_122: (wrapMusic sel_608?))
					(wrapMusic sel_111: 1)
				)
				(WrapMusic sel_168: 0)
				(if (and (== global123 3) (not (proc0_10 8512)))
					((ScriptID 22 0) sel_57: 8512)
				)
				(proc0_8 0)
				(self sel_111:)
			)
		)
	)
)

(instance sHeimlichShoos of Script
	(properties
		sel_20 {sHeimlichShoos}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_139 60)
			)
			(1
				(gLb2Messager sel_295: 3 0 83 0 self 1889)
			)
			(2
				(gEgo sel_312: PolyPath 300 142 self)
			)
			(3 (sel_42 sel_146: sExitNorth))
		)
	)
)

(instance sDie of Script
	(properties
		sel_20 {sDie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(oriley sel_2: 424)
				(proc0_5 gEgo oriley)
				(= sel_136 1)
			)
			(1
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
				(= sel_136 4)
			)
			(2
				(oriley sel_4: 0 sel_161: End self)
			)
			(3
				(sFX sel_40: 80 sel_99: 5 sel_3: 1 sel_39:)
				(gEgo
					sel_2: 858
					sel_153: (+ (gEgo sel_1?) 13) (gEgo sel_0?)
					sel_161: End self
				)
			)
			(4 (= sel_137 4))
			(5
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sCopyFail of Script
	(properties
		sel_20 {sCopyFail}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 2)
			)
			(1
				(gLb2Messager sel_295: 26 0 0 0 self)
			)
			(2 (= sel_137 5))
			(3
				(= global145 3)
				(global2 sel_399: 99)
			)
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		sel_20 {southExitFeature}
		sel_6 166
		sel_7 314
		sel_8 189
		sel_9 319
		sel_33 14
		sel_583 2
		sel_213 25
	)
)

(instance oRileyTimer of Timer
	(properties
		sel_20 {oRileyTimer}
	)
	
	(method (sel_145)
		(oriley sel_312: PChase gEgo 20 oriley)
	)
)

(instance wrapMusic of WrapMusic
	(properties
		sel_20 {wrapMusic}
	)
	
	(method (sel_110)
		(= sel_608 fooSound)
		(super sel_110: &rest)
	)
)

(instance fooSound of Sound
	(properties
		sel_20 {fooSound}
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
