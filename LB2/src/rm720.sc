;;; Sierra Script 1.0 - (do not remove this comment)
(script# 720)
(include sci.sh)
(use Main)
(use LBRoom)
(use Osc)
(use PolyPath)
(use CueObj)
(use n958)
(use StopWalk)
(use Timer)
(use Sound)
(use Cycle)
(use InvI)
(use View)
(use Obj)

(public
	rm720 0
)

(local
	local0
	local1
)
(instance rm720 of LBRoom
	(properties
		sel_20 {rm720}
		sel_213 23
		sel_408 720
		sel_409 730
		sel_412 715
		sel_108 -10
	)
	
	(method (sel_110 &tmp temp0)
		(global2 sel_259: (List sel_109:))
		((ScriptID 2720 0) sel_57: (global2 sel_259?))
		(gEgo sel_110: sel_585: 831 sel_320: 145)
		(self sel_146: sEnterWest)
		(Load rsVIEW 722)
		(proc958_0 132 48 721 722 723 736 17)
		((= temp0 (Inv sel_64: 15)) sel_4: 0)
		(temp0 sel_33: 84)
		(super sel_110:)
		(gSel_608 sel_40: 720 sel_99: 1 sel_3: -1 sel_39:)
		(steve sel_110:)
		(stone sel_110:)
		(maintDoor sel_110: sel_311: 4)
		(furnaceDoor sel_110: sel_311: 4)
		(stairs sel_110:)
		(junk1 sel_110:)
		(junk2 sel_110:)
		(coal sel_110:)
		(coalOnFace sel_110:)
		(coalOnFaceFeat sel_110:)
		(smellHere sel_110:)
		(shovel1 sel_110:)
		(coalShute sel_110:)
		(longPipe sel_110:)
		(bigPipes sel_110:)
		(drain sel_110:)
		(shovel2 sel_110:)
		(tunnel sel_110:)
		(pipe1 sel_110:)
		(pipe2 sel_110:)
		(furnace sel_110:)
		(flames sel_110:)
		(light1 sel_110:)
		(light2 sel_110:)
		(furnaceGrate sel_110:)
	)
	
	(method (sel_111)
		(if (gLb2WH sel_122: tunnel) (gLb2WH sel_81: tunnel))
		(DisposeScript 2720)
		(gSel_608 sel_170:)
		(super sel_111:)
	)
	
	(method (sel_145)
		(cond 
			((self sel_142?) (rileyTimer sel_162: self 10) (self sel_135: rileyTimer))
			(local0
				(gGameMusic2 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				(self sel_146: sO_RileyEnters)
			)
			(else (self sel_146: sGunShots))
		)
	)
	
	(method (sel_399)
		(rileyTimer sel_111: sel_81:)
		(super sel_399: &rest)
	)
)

(instance sGunShots of Script
	(properties
		sel_20 {sGunShots}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(sFX sel_40: 52 sel_3: 1 sel_99: 5 sel_39: self)
			)
			(1 (= sel_139 30))
			(2 (sFX sel_39: self))
			(3
				(gLb2Messager sel_295: 22)
				(rileyTimer sel_162: global2 30)
				(global2 sel_135: rileyTimer)
				(gGameMusic2 sel_40: 17 sel_3: -1 sel_99: 1 sel_39:)
				(Load rsSOUND 3)
				(= local0 1)
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
				(gGame sel_587:)
				(gEgo
					sel_2: 723
					sel_155: 2
					sel_153: 0 161
					sel_312: MoveTo 54 187 self
				)
			)
			(1
				(rileyTimer sel_162: global2 0 2)
				(global2 sel_135: rileyTimer)
				(gEgo sel_585: 831 sel_3: 6)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sO_RileyEnters of Script
	(properties
		sel_20 {sO'RileyEnters}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(o_Riley
					sel_110:
					sel_155: 7
					sel_161: Walk
					sel_312: MoveTo 62 189 self
				)
				(if (< (gEgo sel_1?) 120)
					(gEgo sel_244: 4 sel_53: 4 sel_312: PolyPath 142 165 self)
				else
					(= sel_136 1)
				)
			)
			(1)
			(2
				(o_Riley sel_63: -1)
				(gEgo sel_244: 6 sel_53: 6 sel_253: 270 self)
				(if (== (steve sel_2?) 812) (steve sel_253: 270))
			)
			(3
				(o_Riley sel_155: 5 sel_156: 0 sel_161: End self)
			)
			(4
				(o_Riley sel_155: 6 sel_156: 0 sel_161: CT 1 1 self)
			)
			(5
				(sFX sel_40: 52 sel_3: 1 sel_99: 5 sel_39:)
				(o_Riley sel_161: CT 1 1 self)
			)
			(6
				(sFX sel_39:)
				(o_Riley sel_161: CT 0 1 self)
			)
			(7
				(gEgo
					sel_2: 722
					sel_155: 4
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(8
				(cond 
					(
						(or
							(== (steve sel_2?) 812)
							(and
								(== (steve sel_2?) 722)
								(== (steve sel_3?) 0)
								(== (steve sel_4?) 7)
							)
						)
						(self sel_146: sKillSteve self)
					)
					((== (steve sel_2?) 721) (self sel_146: sKillCoalSteve self))
					((== (steve sel_2?) 722) (self sel_146: sKillNailSteve self))
				)
			)
			(9 (= sel_139 120))
			(10
				(= global145 10)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sKillSteve of Script
	(properties
		sel_20 {sKillSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(o_Riley sel_155: 6 sel_156: 0 sel_161: CT 1 1 self)
			)
			(1
				(sFX sel_40: 52 sel_3: 1 sel_99: 5 sel_39:)
				(o_Riley sel_161: CT 1 1 self)
			)
			(2
				(sFX sel_39:)
				(o_Riley sel_161: CT 0 1 self)
			)
			(3
				(steve
					sel_2: 722
					sel_155: 3
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(4 (self sel_111:))
		)
	)
)

(instance sKillCoalSteve of Script
	(properties
		sel_20 {sKillCoalSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(o_Riley
					sel_155: 7
					sel_161: Walk
					sel_312: MoveTo (- (steve sel_1?) 40) (+ (steve sel_0?) 20) self
				)
			)
			(1
				(o_Riley sel_155: 5 sel_156: 0 sel_161: End self)
			)
			(2
				(o_Riley sel_155: 6 sel_156: 0 sel_161: CT 1 1 self)
			)
			(3
				(sFX sel_40: 52 sel_3: 1 sel_99: 5 sel_39:)
				(o_Riley sel_161: CT 1 1 self)
			)
			(4
				(sFX sel_39:)
				(o_Riley sel_161: CT 0 1 self)
			)
			(5 (steve sel_161: Osc 1 self))
			(6 (self sel_111:))
		)
	)
)

(instance sKillNailSteve of Script
	(properties
		sel_20 {sKillNailSteve}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(o_Riley
					sel_155: 7
					sel_161: Walk
					sel_312: MoveTo (- (steve sel_1?) 50) (+ (steve sel_0?) 20) self
				)
			)
			(1
				(o_Riley sel_155: 5 sel_156: 0 sel_161: End self)
			)
			(2
				(o_Riley sel_155: 6 sel_156: 0 sel_161: CT 1 1 self)
			)
			(3
				(sFX sel_40: 52 sel_3: 1 sel_99: 5 sel_39:)
				(o_Riley sel_161: CT 1 1 self)
			)
			(4
				(sFX sel_39:)
				(o_Riley sel_161: CT 0 1 self)
			)
			(5
				(steve sel_156: (- (steve sel_4?) 1))
				(= sel_139 20)
			)
			(6
				(steve sel_156: (+ (steve sel_4?) 1))
				(= sel_139 20)
			)
			(7 (self sel_111:))
		)
	)
)

(instance sBurnBabyBurn of Script
	(properties
		sel_20 {sBurnBabyBurn}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 721
					sel_155: 4
					sel_156: 0
					sel_244: 12
					sel_161: CT 3 1 self
				)
			)
			(1
				(gEgo sel_161: End self)
				(furnaceDoor sel_244: 12 sel_161: End)
			)
			(2
				(sFX sel_40: 736 sel_3: 1 sel_99: 1 sel_39:)
				(flames sel_161: End self)
			)
			(3
				(flames sel_161: Beg)
				(gEgo sel_155: 5 sel_156: 0 sel_244: 13 sel_161: End self)
			)
			(4 (= sel_139 120))
			(5
				(= global145 2)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sRemoveCoal of Script
	(properties
		sel_20 {sRemoveCoal}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 279 172 self)
			)
			(1
				(gEgo
					sel_2: 721
					sel_155: 0
					sel_156: 0
					sel_161: CT 2 1 self
				)
			)
			(2
				(coalOnFace sel_111:)
				(coalOnFaceFeat sel_111:)
				(gEgo sel_161: End self)
			)
			(3
				(gEgo sel_585: 831 sel_3: 0)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sAwaken of Script
	(properties
		sel_20 {sAwaken}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(smellHere sel_111:)
				(gEgo sel_312: PolyPath 279 172 self)
			)
			(1
				(gEgo sel_2: 721 sel_155: 0 sel_156: 0 sel_161: End self)
			)
			(2 (steve sel_161: Osc 1 self))
			(3 (= sel_139 60))
			(4
				(gEgo
					sel_585: 831
					sel_3: 0
					sel_312: PolyPath 237 165 self
				)
			)
			(5 (gEgo sel_253: 90 self))
			(6
				(steve
					sel_155: 2
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(7
				(gGame sel_588:)
				(gIconBar sel_233: 0)
				(= sel_137 (if (HaveMouse) 6 else 12))
			)
			(8
				(global2 sel_146: sStepOnNail)
				(self sel_111:)
			)
		)
	)
)

(instance sStepOnNail of Script
	(properties
		sel_20 {sStepOnNail}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(steve
					sel_2: 722
					sel_155: 1
					sel_156: 0
					sel_153: 265 173
					sel_161: End self
				)
			)
			(1 (= sel_139 45))
			(2
				(gEgo sel_253: 135)
				(steve
					sel_155: 2
					sel_156: 0
					sel_161: End self
					sel_312: MoveTo 258 182 self
				)
				(sFX sel_40: 722 sel_99: 5 sel_39:)
			)
			(3)
			(4
				(sFX sel_170:)
				(proc0_3 65)
				((global2 sel_259?)
					sel_81: ((global2 sel_259?) sel_64: 0)
				)
				((ScriptID 2720 0) sel_57: (global2 sel_259?))
				(steve sel_313:)
				(gIconBar sel_177: 0)
				(self sel_111:)
			)
		)
	)
)

(instance sGetUp of Script
	(properties
		sel_20 {sGetUp}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(steve sel_155: 3 sel_156: 0 sel_161: End self)
			)
			(1 (= sel_139 30))
			(2
				(steve
					sel_2: 722
					sel_155: 0
					sel_156: 0
					sel_153: 265 173
					sel_161: CT 2 1 self
				)
			)
			(3
				(sFX sel_40: 723 sel_99: 1 sel_39:)
				(steve sel_161: End self)
			)
			(4
				(sFX sel_167:)
				(= local1 1)
				(steve sel_63: -1 sel_313:)
				(proc0_3 121)
				((global2 sel_259?)
					sel_81: ((global2 sel_259?) sel_64: 0)
				)
				((ScriptID 2720 0) sel_57: (global2 sel_259?))
				(gLb2Messager sel_295: 21 2 5)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sSteveHelp of Script
	(properties
		sel_20 {sSteveHelp}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(steve
					sel_2: 724
					sel_63: -1
					sel_155: 0
					sel_156: 0
					sel_244: 6
					sel_53: 6
					sel_161: Walk
					sel_320: 173
					sel_312: MoveTo 230 162 self
				)
			)
			(1
				(steve sel_155: 1 sel_156: 0 sel_312: MoveTo 233 154 self)
			)
			(2
				(steve sel_155: 2 sel_156: 0 sel_312: MoveTo 270 153 self)
			)
			(3
				(sMoveStone sel_145:)
				(self sel_111:)
			)
		)
	)
)

(instance sPushStone of Script
	(properties
		sel_20 {sPushStone}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 240 154 self)
			)
			(1
				(gEgo
					sel_2: 721
					sel_155: 7
					sel_156: 0
					sel_244: 12
					sel_161: CT 4 1 self
				)
			)
			(2 (= sel_139 60))
			(3 (gEgo sel_161: Beg self))
			(4
				(gLb2Messager sel_295: 5 4 4)
				(gEgo sel_585: 831 sel_3: 3)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sMoveStone of Script
	(properties
		sel_20 {sMoveStone}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 240 151 self)
				(steve sel_146: sSteveHelp)
			)
			(1)
			(2
				(gEgo
					sel_2: 721
					sel_155: 7
					sel_156: 0
					sel_244: 12
					sel_161: Osc 1
				)
				(steve
					sel_2: 721
					sel_155: 6
					sel_156: 0
					sel_244: 12
					sel_161: Osc 1
				)
				(stone sel_312: MoveTo 176 (stone sel_0?) self)
				(sFX sel_40: 721 sel_99: 5 sel_39:)
			)
			(3
				(sFX sel_167:)
				(stone sel_313:)
				(gEgo sel_161: Beg self)
				(steve sel_161: Beg)
			)
			(4
				(gEgo sel_585: 831 sel_3: 3)
				(steve
					sel_2: 812
					sel_3: 3
					sel_320: 0
					sel_244: 6
					sel_313:
					sel_161: StopWalk -1
				)
				(gLb2WH sel_129: tunnel)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterTunnel of Script
	(properties
		sel_20 {sEnterTunnel}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 251 146 self)
			)
			(1 (gEgo sel_253: 0 self))
			(2
				(gEgo sel_2: 721 sel_155: 8 sel_156: 0 sel_161: End self)
			)
			(3
				(gEgo
					sel_155: 9
					sel_156: 0
					sel_153: 253 125
					sel_63: 7
					sel_244: 12
					sel_161: Fwd
					sel_312: MoveTo 281 98 self
				)
			)
			(4
				(gEgo sel_102:)
				(steve sel_155: -1 sel_312: PolyPath 254 148 self)
			)
			(5
				(steve
					sel_2: 721
					sel_155: 10
					sel_156: 0
					sel_161: End self
				)
			)
			(6
				(steve
					sel_155: 11
					sel_156: 0
					sel_153: 254 129
					sel_63: 7
					sel_244: 9
					sel_161: Fwd
					sel_312: MoveTo 285 94 self
				)
			)
			(7
				(steve sel_102:)
				(global2 sel_399: (global2 sel_409?))
				(self sel_111:)
			)
		)
	)
)

(instance rileyTimer of Timer
	(properties
		sel_20 {rileyTimer}
	)
)

(instance steve of Actor
	(properties
		sel_20 {steve}
		sel_1 261
		sel_0 148
		sel_213 21
		sel_2 721
		sel_3 1
		sel_60 12
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(cond 
					((and (== sel_3 1) (== sel_2 721)) (gLb2Messager sel_295: 21 1 1))
					((and (== sel_3 2) (== sel_2 722)) (gLb2Messager sel_295: 21 1 2))
					(else (super sel_300: param1))
				)
			)
			(27
				(if local1
					(gEgo sel_351: 16)
					((ScriptID 21 1) sel_57: 785)
					(gLb2Messager sel_295: 21 27)
				)
			)
			(23
				(if (and (== sel_3 2) (== sel_2 721))
					(gEgo sel_351: 12)
					((ScriptID 21 1) sel_57: 781)
					(global2 sel_146: sGetUp)
				else
					(super sel_300: param1)
				)
			)
			(8
				(if
					(or
						(== sel_2 812)
						(and
							(== (steve sel_2?) 722)
							(== (steve sel_3?) 0)
							(== (steve sel_4?) 7)
						)
					)
					(gLb2Messager sel_295: 21 8)
				else
					(super sel_300: param1)
				)
			)
			(4
				(if (and (== sel_3 1) (== sel_2 721))
					(gEgo sel_312: PolyPath 279 172 self)
				else
					(super sel_300: param1)
				)
			)
			(6
				(if
					(or
						(== sel_2 812)
						(and
							(== (steve sel_2?) 722)
							(== (steve sel_3?) 0)
							(== (steve sel_4?) 7)
						)
					)
					(gLb2Messager sel_295: 21 6 7)
				else
					(super sel_300: param1)
				)
			)
			(2
				(if
					(or
						(== sel_2 812)
						(and
							(== (steve sel_2?) 722)
							(== (steve sel_3?) 0)
							(== (steve sel_4?) 7)
						)
					)
					(gLb2Messager sel_295: 21 2 8)
				else
					(super sel_300: param1)
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(gLb2Messager sel_295: 21 4 1)
	)
)

(instance o_Riley of Actor
	(properties
		sel_20 {o'Riley}
		sel_0 163
		sel_2 722
		sel_3 5
		sel_60 15
		sel_14 16400
	)
)

(instance stone of Actor
	(properties
		sel_20 {stone}
		sel_1 224
		sel_0 78
		sel_213 5
		sel_2 723
		sel_3 1
		sel_60 8
		sel_14 17
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					((and local1 (== sel_1 224)) (global2 sel_146: sMoveStone))
					((and local1 (!= sel_1 224)) 0)
					(else (global2 sel_146: sPushStone))
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance furnaceDoor of Prop
	(properties
		sel_20 {furnaceDoor}
		sel_1 141
		sel_0 117
		sel_213 4
		sel_303 189
		sel_304 163
		sel_2 723
		sel_60 11
		sel_14 17
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sBurnBabyBurn)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance flames of Prop
	(properties
		sel_20 {flames}
		sel_1 144
		sel_0 101
		sel_2 723
		sel_3 3
		sel_60 10
		sel_14 17
	)
)

(instance coalOnFace of View
	(properties
		sel_20 {coalOnFace}
		sel_1 297
		sel_0 135
		sel_2 721
		sel_3 13
		sel_60 13
		sel_14 16401
	)
)

(instance coalOnFaceFeat of Feature
	(properties
		sel_20 {coalOnFaceFeat}
		sel_0 155
		sel_6 129
		sel_7 290
		sel_8 139
		sel_9 301
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 21 1 1)
			)
			(4
				(global2 sel_146: sRemoveCoal)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance smellHere of Feature
	(properties
		sel_20 {smellHere}
		sel_0 154
		sel_6 129
		sel_7 290
		sel_8 139
		sel_9 301
		sel_303 297
		sel_304 134
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 21 1 1)
			)
			(4
				(gEgo sel_312: PolyPath 279 172 steve)
			)
			(24 (global2 sel_146: sAwaken))
			(else  (super sel_300: param1))
		)
	)
)

(instance stairs of Feature
	(properties
		sel_20 {stairs}
		sel_0 1
		sel_213 9
		sel_302 2
	)
)

(instance junk1 of Feature
	(properties
		sel_20 {junk1}
		sel_0 1
		sel_213 10
		sel_302 4
	)
)

(instance junk2 of Feature
	(properties
		sel_20 {junk2}
		sel_0 1
		sel_213 11
		sel_302 8
	)
)

(instance coal of Feature
	(properties
		sel_20 {coal}
		sel_0 1
		sel_213 12
		sel_302 16
	)
)

(instance shovel1 of Feature
	(properties
		sel_20 {shovel1}
		sel_1 300
		sel_0 1
		sel_213 13
		sel_302 32
	)
)

(instance coalShute of Feature
	(properties
		sel_20 {coalShute}
		sel_0 1
		sel_213 14
		sel_302 64
	)
)

(instance longPipe of Feature
	(properties
		sel_20 {longPipe}
		sel_0 1
		sel_213 15
		sel_302 128
	)
)

(instance bigPipes of Feature
	(properties
		sel_20 {bigPipes}
		sel_0 1
		sel_213 16
		sel_302 256
	)
)

(instance drain of Feature
	(properties
		sel_20 {drain}
		sel_0 1
		sel_213 17
		sel_302 512
	)
)

(instance shovel2 of Feature
	(properties
		sel_20 {shovel2}
		sel_0 1
		sel_213 18
		sel_302 1024
	)
)

(instance tunnel of Feature
	(properties
		sel_20 {tunnel}
		sel_0 1
		sel_213 19
		sel_302 2048
		sel_303 255
		sel_304 135
	)
	
	(method (sel_300 param1)
		(switch param1
			(3
				(global2 sel_146: sEnterTunnel)
			)
			(4
				(global2 sel_146: sEnterTunnel)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance pipe1 of Feature
	(properties
		sel_20 {pipe1}
		sel_0 1
		sel_213 1
		sel_302 4096
	)
)

(instance pipe2 of Feature
	(properties
		sel_20 {pipe2}
		sel_0 1
		sel_213 2
		sel_302 8192
	)
)

(instance furnace of Feature
	(properties
		sel_20 {furnace}
		sel_0 1
		sel_213 3
		sel_302 16384
	)
)

(instance light1 of Feature
	(properties
		sel_20 {light1}
		sel_1 64
		sel_0 73
		sel_213 7
		sel_6 67
		sel_7 59
		sel_8 80
		sel_9 70
		sel_301 40
	)
)

(instance light2 of Feature
	(properties
		sel_20 {light2}
		sel_1 232
		sel_0 68
		sel_213 8
		sel_6 62
		sel_7 225
		sel_8 75
		sel_9 239
		sel_301 40
	)
)

(instance furnaceGrate of Feature
	(properties
		sel_20 {furnaceGrate}
		sel_1 158
		sel_0 136
		sel_213 6
		sel_6 128
		sel_7 141
		sel_8 145
		sel_9 176
		sel_301 40
	)
)

(instance maintDoor of Feature
	(properties
		sel_20 {maintDoor}
		sel_0 1
		sel_213 20
		sel_6 86
		sel_7 7
		sel_8 139
		sel_9 35
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(sFXLocked sel_39:)
				(gLb2Messager sel_295: 20 4)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)

(instance sFXLocked of Sound
	(properties
		sel_20 {sFXLocked}
		sel_99 5
		sel_40 48
	)
)
