;;; Sierra Script 1.0 - (do not remove this comment)
(script# 530)
(include sci.sh)
(use Main)
(use LBRoom)
(use Scaler)
(use Osc)
(use PolyPath)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm530 0
)

(instance rm530 of LBRoom
	(properties
		sel_20 {rm530}
		sel_408 530
		sel_409 600
		sel_411 510
		sel_107 0
	)
	
	(method (sel_110)
		(proc958_0 128 530 541 542 831)
		(proc958_0 132 540 541 542 543 558)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 105 0 190 0)
		(self sel_414: 90)
		(switch gGSel_40
			(sel_409
				(proc0_3 31)
				(gEgo sel_1: 236 sel_0: 136)
				(self sel_146: sUpStairs)
			)
			(sel_411
				(self sel_146: sEnterSouth)
			)
			(else 
				(gEgo sel_153: 65 180)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(if (and (proc0_2 31) (proc0_2 33))
			(gLb2WH sel_129: wallInside pit rearStairs)
		)
		(if (proc0_2 31)
			(if (proc0_2 32)
				(darkPassage sel_110:)
				(lightBulb sel_110: sel_156: 1)
			else
				(lightBulb sel_110:)
			)
		else
			(doorSeam sel_110:)
			(secretDoor sel_317:)
		)
		(windows sel_110:)
		(stairwellWall sel_110:)
		(hallWall sel_110:)
		(floor sel_110:)
		(stairs sel_110:)
		(pit sel_110:)
		(wallInside sel_110:)
		(rearStairs sel_110:)
		(socket sel_110:)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 16384) (self sel_146: sExitSouth))
			((proc0_1 gEgo 8192) (self sel_146: sExitSouthWalk))
			((and (proc0_1 gEgo 8) (proc0_2 32)) (self sel_146: sFallStairs))
		)
	)
	
	(method (sel_111)
		(if (proc0_2 33)
			(gLb2WH sel_81: wallInside pit rearStairs)
		)
		(super sel_111:)
	)
)

(instance lightBulb of View
	(properties
		sel_20 {lightBulb}
		sel_1 162
		sel_0 109
		sel_213 14
		sel_2 541
		sel_3 4
		sel_60 15
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (not sel_4)
					(gLb2Messager sel_295: sel_213 param1 2)
				else
					(gLb2Messager sel_295: sel_213 param1 1)
				)
			)
			(39
				(if (not sel_4)
					(global2 sel_146: sReadCarbonPaper)
				else
					(gLb2Messager sel_295: sel_213 param1 4)
				)
			)
			(4
				(cond 
					(
					(or (gEgo sel_238: 23) (not (proc0_2 64)) (not sel_4)) (gLb2Messager sel_295: sel_213 param1 5))
					((not sel_4) (gLb2Messager sel_295: sel_213 param1 2))
					(else (gLb2Messager sel_295: sel_213 param1 1))
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance darkPassage of View
	(properties
		sel_20 {darkPassage}
		sel_1 111
		sel_0 88
		sel_213 11
		sel_2 530
		sel_3 1
		sel_60 5
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (== (lightBulb sel_4?) 0)
					(gLb2Messager sel_295: 11 1 2)
				else
					(gLb2Messager sel_295: 11 1)
				)
			)
			(8
				(if (== (lightBulb sel_4?) 0)
					(gLb2Messager sel_295: 11 8 2)
				else
					(gLb2Messager sel_295: 11 8)
				)
			)
			(33
				(global2 sel_146: sReplaceLightBulb)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance secretDoor of View
	(properties
		sel_20 {secretDoor}
		sel_1 113
		sel_0 89
		sel_213 10
		sel_2 530
		sel_60 13
		sel_14 16401
	)
)

(instance windows of Feature
	(properties
		sel_20 {windows}
		sel_0 1
		sel_213 1
		sel_301 40
		sel_302 2
	)
)

(instance stairs of Feature
	(properties
		sel_20 {stairs}
		sel_0 1
		sel_213 6
		sel_301 40
		sel_302 4
	)
	
	(method (sel_307)
	)
)

(instance rearStairs of Feature
	(properties
		sel_20 {rearStairs}
		sel_0 1
		sel_213 6
		sel_301 40
		sel_302 4096
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(3
				(if (and (proc0_2 33) (proc0_2 31))
					(global2 sel_146: sExitNorth)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance pit of Feature
	(properties
		sel_20 {pit}
		sel_0 1
		sel_213 7
		sel_301 40
		sel_302 8
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (== (lightBulb sel_4?) 0)
					(gLb2Messager sel_295: 7 1 2)
				else
					(gLb2Messager sel_295: 7 1)
				)
			)
			(3
				(if (and (proc0_2 33) (proc0_2 31))
					(global2 sel_146: sExitNorth)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance socket of Feature
	(properties
		sel_20 {socket}
		sel_0 1
		sel_213 9
		sel_301 40
		sel_302 16
	)
)

(instance doorSeam of Feature
	(properties
		sel_20 {doorSeam}
		sel_0 1
		sel_213 5
		sel_301 40
		sel_302 32
	)
)

(instance wallInside of Feature
	(properties
		sel_20 {wallInside}
		sel_0 1
		sel_213 8
		sel_301 40
		sel_302 128
	)
	
	(method (sel_300 param1)
		(switch param1
			(3
				(if (and (proc0_2 33) (proc0_2 31))
					(global2 sel_146: sExitNorth)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance stairwellWall of Feature
	(properties
		sel_20 {stairwellWall}
		sel_0 1
		sel_213 2
		sel_301 40
		sel_302 256
	)
)

(instance hallWall of Feature
	(properties
		sel_20 {hallWall}
		sel_0 1
		sel_213 3
		sel_301 40
		sel_302 512
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_0 1
		sel_213 15
		sel_301 40
		sel_302 1024
	)
)

(instance sReplaceLightBulb of Script
	(properties
		sel_20 {sReplaceLightBulb}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_141 (Sound sel_109:))
				(gEgo sel_312: PolyPath 155 161 self)
			)
			(1 (gEgo sel_253: 0 self))
			(2
				(gEgo
					sel_2: 541
					sel_155: 1
					sel_156: 0
					sel_153: 153 158
					sel_161: CT 3 1 self
				)
			)
			(3
				(gEgo sel_161: ScrewInBulb 6 sel_141 self)
			)
			(4
				(gGame sel_87: 1 167)
				(sFX sel_40: 558 sel_39:)
				(lightBulb sel_156: 0)
				(darkPassage sel_102:)
				(= sel_136 1)
			)
			(5 (gEgo sel_161: End self))
			(6
				((ScriptID 21 1) sel_57: 792)
				(gEgo sel_585: 831 sel_3: 6 sel_4: 5 sel_153: 152 158)
				(proc0_4 32)
				(proc0_3 33)
				(gEgo sel_351: 23)
				(gLb2WH sel_129: wallInside pit rearStairs)
				(lightBulb sel_313:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sReadCarbonPaper of Script
	(properties
		sel_20 {sReadCarbonPaper}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 155 161 self)
			)
			(1 (gEgo sel_253: 0 self))
			(2
				(gEgo
					sel_2: 541
					sel_155: 2
					sel_156: 0
					sel_153: 153 158
					sel_161: End self
				)
			)
			(3
				(gLb2Messager sel_295: 14 39 3)
				(gGame sel_87: 1 170)
				(= sel_136 1)
			)
			(4 (gEgo sel_161: Beg self))
			(5
				(gEgo
					sel_351: 29
					sel_155: 6
					sel_156: 5
					sel_153: 152 158
					sel_585: 831
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sFallStairs of Script
	(properties
		sel_20 {sFallStairs}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 167 150 self)
			)
			(1
				(gEgo
					sel_2: 542
					sel_155: 0
					sel_156: 0
					sel_153: 169 148
					sel_161: End self
				)
			)
			(2
				(cutPassageBottomMask sel_110:)
				(cutFloorMask sel_110:)
				(gEgo
					sel_63: 6
					sel_52: 16
					sel_312: MoveTo (gEgo sel_1?) 183 self
				)
				(sFX sel_40: 542 sel_99: 1 sel_155: 1 sel_39:)
			)
			(3
				(gEgo sel_102:)
				(= sel_139 120)
			)
			(4
				(sFX sel_40: 543 sel_39:)
				(= sel_139 180)
			)
			(5
				(= global145 14)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance cutPassageBottomMask of View
	(properties
		sel_20 {cutPassageBottomMask}
		sel_1 111
		sel_0 149
		sel_2 530
		sel_3 2
		sel_60 14
		sel_14 16401
	)
)

(instance cutFloorMask of View
	(properties
		sel_20 {cutFloorMask}
		sel_1 111
		sel_0 178
		sel_2 530
		sel_3 3
		sel_60 15
		sel_14 16401
	)
)

(instance sUpStairs of Script
	(properties
		sel_20 {sUpStairs}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gGameMusic2 sel_40: 540 sel_3: -1 sel_99: 1 sel_39:)
				(= sel_136 3)
			)
			(1
				(gEgo sel_312: MoveTo 103 138 self)
			)
			(2
				(gEgo sel_312: MoveTo 109 161 self)
			)
			(3
				(gGameMusic2 sel_170:)
				(gEgo sel_312: MoveTo 147 162 self)
			)
			(4
				(WrapMusic sel_168: 0)
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
				(gEgo sel_312: PolyPath 136 158 self)
			)
			(1
				(WrapMusic sel_168: 1)
				(gGameMusic2 sel_40: 541 sel_3: -1 sel_99: 1 sel_39:)
				(gEgo
					sel_2: 541
					sel_155: 0
					sel_156: 0
					sel_153: 127 165
					sel_63: 12
					sel_161: End self
				)
			)
			(2
				(gEgo
					sel_585: 831
					sel_153: 99 161
					sel_63: -1
					sel_312: MoveTo 107 140 self
				)
			)
			(3
				(gEgo sel_312: PolyPath 221 147 self)
			)
			(4
				(gEgo sel_349: 1)
				(global2 sel_399: (global2 sel_409?))
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
				(global2 sel_399: (global2 sel_411?))
			)
		)
	)
)

(instance sExitSouthWalk of Script
	(properties
		sel_20 {sExitSouthWalk}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(if (> (gEgo sel_1?) 150)
					(gEgo sel_312: MoveTo 229 148 self)
				else
					(gEgo sel_312: MoveTo 88 147 self)
				)
			)
			(1
				(global2 sel_399: (global2 sel_411?))
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
				(if (> (Random 0 1) 0)
					(gEgo
						sel_153: 84 152
						sel_253: 270
						sel_312: MoveTo 58 161 self
					)
				else
					(gEgo
						sel_153: 238 155
						sel_253: 90
						sel_312: MoveTo 262 157 self
					)
				)
			)
			(1
				(if (and (proc0_2 31) (not (proc0_2 32)))
					(if (proc0_2 33)
						(gGame sel_588:)
						(self sel_111:)
					else
						(gGame sel_588:)
						(= sel_139 120)
					)
				else
					(gGame sel_588:)
					(self sel_111:)
				)
			)
			(2
				(proc0_3 32)
				(sFX sel_40: 558 sel_39:)
				(lightBulb sel_156: 1)
				(darkPassage sel_110:)
				(= sel_139 120)
			)
			(3
				(gLb2Messager sel_295: 12 0 1)
				(self sel_111:)
			)
		)
	)
)

(class ScrewInBulb of Osc
	(properties
		sel_20 {ScrewInBulb}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_469 -1
		sel_607 1
	)
	
	(method (sel_110 param1 theSel_469 theSel_607 theSel_143)
		(if (>= argc 2)
			(= sel_469 theSel_469)
			(if (>= argc 3)
				(= sel_607 theSel_607)
				(if (>= argc 4) (= sel_143 theSel_143))
			)
		)
		(super sel_110: param1 theSel_469 theSel_143)
	)
	
	(method (sel_57 &tmp screwInBulbSel_241)
		(if
			(or
				(> (= screwInBulbSel_241 (self sel_241:)) 4)
				(< screwInBulbSel_241 3)
			)
			(= sel_239 (- sel_239))
			(self sel_242:)
		else
			(sel_42 sel_4: screwInBulbSel_241)
		)
	)
	
	(method (sel_242)
		(sel_607 sel_40: 553 sel_39:)
		(super sel_242:)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
