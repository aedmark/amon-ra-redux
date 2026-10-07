;;; Sierra Script 1.0 - (do not remove this comment)
(script# 510)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use StopWalk)
(use Timer)
(use Sound)
(use Cycle)
(use InvI)
(use View)
(use Obj)

(public
	rm510 0
	eastDoor 2
)

(local
	local0
	local1
)
(instance rm510 of LBRoom
	(properties
		sel_20 {rm510}
		sel_213 10
		sel_408 510
		sel_409 530
		sel_410 550
		sel_411 520
		sel_412 500
		sel_107 0
	)
	
	(method (sel_110)
		(proc958_0 128 510 511 831)
		(if (and (== global123 4) (== global111 11))
			(proc958_0 128 820 812 817)
			(Load rsSOUND 332)
		)
		(proc958_0 132 531 721)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 120 75 190 120)
		(self sel_414: 90)
		(switch gGSel_40
			(521
				(gGame sel_587:)
				(gEgo sel_153: 86 175)
				(WrapMusic sel_168: 0)
				(self sel_146: sOlympiaEnters)
			)
			(sel_409
				(gEgo sel_1: 278 sel_0: 147)
				(self sel_146: sEnterNorth)
			)
			(sel_410
				(gEgo sel_349: 0 sel_253: 180)
				(if (and (== global123 4) (== global111 11))
					(WrapMusic sel_168: 1)
					(gGameMusic2 sel_40: 332 sel_3: -1 sel_99: 1 sel_39:)
					(olympia
						sel_110:
						sel_161: StopWalk -1
						sel_320: Scaler 140 20 190 0
					)
					(steve
						sel_110:
						sel_161: StopWalk -1
						sel_320: Scaler 140 20 190 0
					)
				else
					(WrapMusic sel_168: 0)
				)
				(self sel_145:)
			)
			(sel_412
				(self sel_146: sEnterWest)
			)
			(26
				(WrapMusic sel_110: 1 90 91 92 93)
				(= global111 11)
				(self sel_146: sEnterWest)
			)
			(sel_411
				(self sel_145:)
				(WrapMusic sel_168: 0)
				(if (== ((Inv sel_64: 14) sel_166?) 0)
					(self sel_146: sFollowOlympia)
					((Inv sel_64: 14) sel_166: 630)
				)
			)
			(else 
				(gEgo sel_153: 86 175)
				(WrapMusic sel_168: 0)
				(self sel_145:)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (proc0_2 31)
			(rodinDudeHead
				sel_110:
				sel_4: (rodinDudeHead sel_246:)
				sel_313:
			)
		else
			(rodinDudeHead sel_110: sel_313:)
		)
		(eastDoor sel_110:)
		(statue1 sel_110:)
		(statue2 sel_110:)
		(statue3 sel_110:)
		(statue4 sel_110:)
		(arch sel_110:)
		(if (not (proc0_2 31)) (rodinSeam sel_110:))
		(rodinBody sel_110:)
		(transom sel_110:)
		(wall sel_110:)
		(southExitFeature sel_110:)
		(if (proc999_5 global111 0 6 10 14)
			(eastDoor sel_590: 1)
		)
		(if
			(and
				(== global123 4)
				(not (== gGSel_40 521))
				(not (proc0_2 62))
				(proc0_10 16648 1)
				(not (proc0_2 92))
			)
			(proc0_3 62)
			(self sel_146: sMeanwhile)
		)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (self sel_146: sExitWest))
			((proc0_1 gEgo 4) (self sel_146: sExitNorth))
			((proc0_1 gEgo 2048) (global2 sel_146: sExitSouth))
		)
	)
	
	(method (sel_145)
		(cond 
			((== global111 0)
				(if (== ((ScriptID 90 2) sel_620?) gSel_40)
					(gGame sel_587:)
					((ScriptID 90 2) sel_618: 550 self)
				else
					((ScriptID 90 2) sel_182: -2)
					(waterPrompt sel_162: waterPrompt 5)
				)
			)
			((proc999_5 global111 4 10 12) (waterPrompt sel_162: waterPrompt 5))
		)
	)
	
	(method (sel_399 param1)
		(if (gTimers sel_122: waterPrompt)
			(waterPrompt sel_111: sel_81:)
		)
		(cond 
			((proc999_5 param1 500 530)
				(switch global111
					(3 (++ global111))
					(5
						(= global111 (+ global111 2))
					)
					(6 (++ global111))
					(13 (++ global111))
				)
			)
			((== param1 520) (WrapMusic sel_168: 1))
		)
		(if (proc999_5 global111 1 11 15)
			((ScriptID 90 6) sel_182: -2)
		)
		(if
			(and
				(== global111 7)
				(== ((ScriptID 90 6) sel_620?) -2)
				(not (proc0_10 -15612))
			)
			((ScriptID 90 6) sel_182: 510 sel_618: 430)
		)
		(if local1 (proc0_4 31))
		(if (!= param1 sel_410) (proc0_4 97))
		(super sel_399: param1)
	)
)

(instance olympia of Actor
	(properties
		sel_20 {olympia}
		sel_1 256
		sel_0 184
		sel_2 820
		sel_4 5
		sel_60 13
		sel_14 16400
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 285
		sel_0 184
		sel_2 812
		sel_3 1
		sel_4 4
		sel_60 13
		sel_14 16
	)
)

(instance yvette of Actor
	(properties
		sel_20 {yvette}
		sel_1 309
		sel_0 159
		sel_2 817
		sel_3 1
		sel_60 13
		sel_14 16
	)
)

(instance rodinDudeHead of Prop
	(properties
		sel_20 {rodinDudeHead}
		sel_1 166
		sel_0 127
		sel_213 6
		sel_2 511
		sel_3 1
		sel_60 14
		sel_14 16
		sel_244 12
	)
	
	(method (sel_110)
		(super sel_110:)
		(self sel_313:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (proc0_2 31)
					(proc0_4 31)
					(rodinSeam sel_110:)
				else
					(gGame sel_87: 1 142)
					(proc0_3 31)
					(rodinSeam sel_111:)
				)
				(rodinDudeHead sel_146: sRodinFlipSwitch)
			)
			(8 (gLb2Messager sel_295: 7 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance eastDoor of Door
	(properties
		sel_20 {eastDoor}
		sel_1 319
		sel_0 95
		sel_213 2
		sel_214 1510
		sel_301 40
		sel_303 309
		sel_304 163
		sel_2 510
		sel_60 8
		sel_14 16
		sel_589 550
		sel_593 38
		sel_597 310
		sel_598 157
		sel_599 0
		sel_600 0
	)
	
	(method (sel_110)
		(super sel_110:)
		(self sel_311: 4 38)
	)
	
	(method (sel_145)
		(super sel_145:)
		(if (== sel_29 0)
			(if (and (== global123 4) (== global111 11))
				(self sel_146: sSteveYvetteMeeting)
			)
			(if
				(and
					(== global123 4)
					(not (== gGSel_40 521))
					(not (proc0_2 62))
					(proc0_10 16648 1)
					(not (proc0_2 92))
				)
				(proc0_3 62)
				(global2 sel_399: 521)
			)
		)
	)
	
	(method (sel_605)
		(if (gTimers sel_122: waterPrompt)
			(waterPrompt sel_111: sel_81:)
		)
		(switch global111
			(0
				(gLb2Messager sel_295: 2 38 2 0 0 1510)
				(++ global111)
			)
			(4
				(gLb2Messager sel_295: 2 38 5 0 0 1510)
				(++ global111)
			)
			(10
				(gLb2Messager sel_295: 2 38 6 0 0 1510)
				(++ global111)
			)
			(12
				(global2 sel_146: sListenToYvetteAndSteve)
				(++ global111)
			)
			(else  (super sel_605:))
		)
	)
	
	(method (sel_606)
		(super sel_606: 297 152 319 156 319 164 297 160)
	)
)

(instance statue1 of Feature
	(properties
		sel_20 {statue1}
		sel_0 1
		sel_213 1
		sel_301 40
		sel_302 32
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(gLb2Messager sel_295: 14 4)
		else
			(super sel_300: param1 &rest)
		)
	)
)

(instance statue2 of Feature
	(properties
		sel_20 {statue2}
		sel_1 100
		sel_0 1
		sel_213 2
		sel_302 64
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(gLb2Messager sel_295: 14 4)
		else
			(super sel_300: param1 &rest)
		)
	)
)

(instance statue3 of Feature
	(properties
		sel_20 {statue3}
		sel_1 200
		sel_0 1
		sel_213 3
		sel_302 128
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(gLb2Messager sel_295: 14 4)
		else
			(super sel_300: param1 &rest)
		)
	)
)

(instance statue4 of Feature
	(properties
		sel_20 {statue4}
		sel_1 300
		sel_0 1
		sel_213 4
		sel_302 256
	)
	
	(method (sel_300 param1)
		(if (== param1 4)
			(gLb2Messager sel_295: 14 4)
		else
			(super sel_300: param1 &rest)
		)
	)
)

(instance arch of Feature
	(properties
		sel_20 {arch}
		sel_0 1
		sel_213 5
		sel_302 16
	)
)

(instance rodinSeam of Feature
	(properties
		sel_20 {rodinSeam}
		sel_1 160
		sel_0 160
		sel_213 7
		sel_301 40
		sel_302 4096
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (proc0_2 31)
					(proc0_4 31)
				else
					(gGame sel_87: 1 142)
					(proc0_3 31)
				)
				(rodinDudeHead sel_146: sRodinFlipSwitch)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance rodinBody of Feature
	(properties
		sel_20 {rodinBody}
		sel_1 160
		sel_0 160
		sel_213 8
		sel_301 40
		sel_302 16384
	)
)

(instance transom of Feature
	(properties
		sel_20 {transom}
		sel_1 360
		sel_0 84
		sel_213 9
		sel_301 40
		sel_302 512
	)
)

(instance wall of Feature
	(properties
		sel_20 {wall}
		sel_0 1
		sel_213 11
		sel_302 1024
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
				(gEgo sel_253: 180 sel_312: MoveFwd 80 self)
			)
			(1
				(global2 sel_399: (global2 sel_411?))
			)
		)
	)
)

(instance sExitWest of Script
	(properties
		sel_20 {sExitWest}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 270 sel_312: MoveFwd 20 self)
			)
			(1
				(global2 sel_399: (global2 sel_412?))
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
				(gGame sel_587:)
				(gEgo
					sel_153: 18 150
					sel_253: 90
					sel_312: MoveFwd 30 self
				)
			)
			(1
				(global2 sel_145:)
				(gGame sel_588:)
				(self sel_111:)
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
				(gEgo sel_312: MoveFwd 25 self)
			)
			(1
				(global2 sel_399: (global2 sel_409?))
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
				(gEgo sel_253: 225 sel_312: PolyPath 247 155 self)
			)
			(1
				(global2 sel_145:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties
		sel_20 {sExitEast}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 45 sel_312: MoveFwd 20 self)
			)
			(1
				(global2 sel_399: (global2 sel_410?))
			)
		)
	)
)

(instance sRodinFlipSwitch of Script
	(properties
		sel_20 {sRodinFlipSwitch}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 186 185 self)
			)
			(1 (gEgo sel_253: 270 self))
			(2
				(gEgo
					sel_2: 511
					sel_155: 0
					sel_4: 0
					sel_153: 174 184
					sel_244: 12
					sel_161: End self
				)
			)
			(3
				(sFX sel_40: 531 sel_99: 1 sel_39:)
				(if (proc0_2 31)
					(rodinDudeHead sel_161: End self)
				else
					(rodinDudeHead sel_161: Beg self)
				)
				(gEgo sel_585: 831 sel_3: 1 sel_153: 186 185)
			)
			(4
				(rodinDudeHead sel_313:)
				(sFX sel_40: 721 sel_99: 5 sel_155: 1 sel_39:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sSteveYvetteMeeting of Script
	(properties
		sel_20 {sSteveYvetteMeeting}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_139 60)
			)
			(1
				(gEgo sel_312: PolyPath 273 172 self)
			)
			(2 (= sel_139 60))
			(3
				(proc0_5 gEgo steve)
				(= sel_139 60)
			)
			(4
				(gLb2Messager sel_295: 1 0 1 1 self 1510)
			)
			(5
				(proc0_5 steve gEgo)
				(= sel_139 60)
			)
			(6
				(gLb2Messager sel_295: 1 0 1 2 self 1510)
			)
			(7
				(proc0_5 olympia gEgo)
				(= sel_139 60)
			)
			(8
				(proc0_5 olympia steve)
				(= sel_139 60)
			)
			(9
				(gLb2Messager sel_295: 1 0 1 3 self 1510)
			)
			(10 (= sel_139 60))
			(11
				(olympia
					sel_161: Walk
					sel_312: PolyPath (olympia sel_1?) 250 self
				)
			)
			(12
				(olympia sel_111:)
				(gEgo sel_312: PolyPath 256 184 self)
			)
			(13
				(proc0_5 gEgo steve)
				(proc0_5 steve gEgo)
				(= sel_139 60)
			)
			(14
				(gLb2Messager sel_295: 1 0 3 0 0 1510)
				(= sel_139 60)
			)
			(15 (= sel_139 60))
			(16
				(eastDoor sel_161: End self)
				(doorSound sel_40: 46 sel_39:)
				(gListSel_109 sel_81: (eastDoor sel_603?))
			)
			(17 (= sel_139 60))
			(18
				(proc0_5 yvette steve)
				(= sel_139 60)
			)
			(19
				(yvette
					sel_110:
					sel_320: Scaler 140 20 190 0
					sel_161: Walk
					sel_312: MoveTo 298 174 self
				)
			)
			(20
				(yvette sel_161: StopWalk -1)
				(= sel_136 1)
			)
			(21
				(proc0_5 yvette steve)
				(= sel_136 10)
			)
			(22
				(proc0_5 yvette gEgo)
				(= sel_136 10)
			)
			(23
				(proc0_5 yvette steve)
				(= sel_136 10)
			)
			(24
				(gLb2Messager sel_295: 1 0 1 17 self 1510)
			)
			(25 (proc0_5 steve yvette self))
			(26 (= sel_136 1))
			(27
				(gLb2Messager sel_295: 1 0 1 18 self 1510)
			)
			(28
				(gLb2Messager sel_295: 1 0 1 19 self 1510)
			)
			(29
				(yvette sel_161: Walk sel_312: MoveTo 309 159 self)
			)
			(30
				(yvette sel_102: sel_111:)
				(= sel_136 1)
			)
			(31
				(proc0_5 steve eastDoor)
				(proc0_5 gEgo eastDoor)
				(= sel_139 60)
			)
			(32
				(proc0_5 steve gEgo)
				(proc0_5 gEgo steve)
				(= sel_139 60)
			)
			(33
				(gLb2Messager sel_295: 1 0 1 20 self 1510)
			)
			(34
				(gLb2Messager sel_295: 1 0 1 21 self 1510)
			)
			(35
				(gLb2Messager sel_295: 1 0 1 22 self 1510)
			)
			(36
				(steve sel_312: MoveTo 309 159 self)
			)
			(37
				(proc0_5 gEgo eastDoor)
				(steve sel_102:)
				(= sel_136 1)
			)
			(38
				(eastDoor sel_161: Beg self)
				(doorSound sel_40: 47 sel_39:)
				(gListSel_109 sel_118: (eastDoor sel_603?))
				(= sel_139 60)
			)
			(39
				(gGameMusic2 sel_170: 0 12 5 1)
				(= sel_136 1)
			)
			(40
				(gLb2Messager sel_295: 1 0 1 23 self 1510)
			)
			(41
				(gLb2Messager sel_295: 1 0 1 24 self 1510)
			)
			(42
				((ScriptID 22 0) sel_57: 8961 self)
			)
			(43
				(++ global111)
				(waterPrompt sel_162: waterPrompt 3)
				(WrapMusic sel_168: 0)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sOlympiaEnters of Script
	(properties
		sel_20 {sOlympiaEnters}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 15))
			(1
				(olympia
					sel_153: 100 210
					sel_161: Walk
					sel_320: Scaler 140 20 190 0
					sel_63: -1
					sel_312: PolyPath (- (gEgo sel_1?) 20) (gEgo sel_0?) self
					sel_110:
				)
				(= sel_137 2)
			)
			(2 (proc0_5 gEgo olympia))
			(3 (proc0_5 gEgo olympia self))
			(4 (proc0_5 olympia gEgo self))
			(5 (= sel_136 1))
			(6
				(olympia sel_161: StopWalk -1)
				(= sel_136 1)
			)
			(7 (= sel_136 1))
			(8
				(gLb2Messager sel_295: 1 0 24 0 self 1892)
			)
			(9
				(olympia sel_312: PolyPath 13 146 self)
			)
			(10
				(gGame sel_588:)
				(olympia sel_111:)
				(proc0_4 62)
				(self sel_111:)
			)
		)
	)
)

(instance sFollowOlympia of Script
	(properties
		sel_20 {sFollowOlympia}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(proc0_3 31)
				(= local1 1)
				(gEgo sel_153: (gEgo sel_1?) (+ (gEgo sel_0?) 20))
				(rodinDudeHead sel_4: (rodinDudeHead sel_246:))
				(olympia
					sel_153: 196 161
					sel_320: Scaler 140 20 190 0
					sel_110:
				)
				(= sel_136 15)
			)
			(1
				(olympia
					sel_63: -1
					sel_161: StopWalk -1
					sel_312: PolyPath 271 142 self
				)
			)
			(2
				(olympia sel_111:)
				(gEgo sel_110: sel_312: PolyPath 86 175 self)
			)
			(3
				(sFX sel_40: 721 sel_99: 5 sel_155: 1 sel_39:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)

(instance doorSound of Sound
	(properties
		sel_20 {doorSound}
		sel_99 5
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
		sel_213 15
	)
)

(instance sMeanwhile of Script
	(properties
		sel_20 {sMeanwhile}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(switch gGSel_40
					((global2 sel_409?)
						(gEgo sel_1: 278 sel_0: 147)
						(self sel_146: sEnterNorth self)
					)
					((global2 sel_412?)
						(self sel_146: sEnterWest self)
					)
					(else  (= sel_136 1))
				)
			)
			(1 (global2 sel_399: 521))
		)
	)
)

(instance sListenToYvetteAndSteve of Script
	(properties
		sel_20 {sListenToYvetteAndSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gLb2Messager sel_295: 2 38 4 0 self 1510)
			)
			(1
				(proc0_3 75)
				(eastDoor sel_300: 4)
			)
		)
	)
)

(instance waterPrompt of Timer
	(properties
		sel_20 {waterPrompt}
	)
	
	(method (sel_145)
		(gLb2Messager sel_295: 16)
	)
)
