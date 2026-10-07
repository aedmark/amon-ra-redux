;;; Sierra Script 1.0 - (do not remove this comment)
(script# 700)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use Inset)
(use PolyPath)
(use CueObj)
(use n958)
(use Timer)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm700 0
)

(local
	local0
	[local1 2]
)
(instance rm700 of LBRoom
	(properties
		sel_20 {rm700}
		sel_213 19
		sel_408 700
		sel_409 660
		sel_412 710
		sel_108 38
	)
	
	(method (sel_110)
		(global2 sel_259: (List sel_109:))
		((ScriptID 2700 0) sel_57: (global2 sel_259?))
		(gEgo
			sel_110:
			sel_585: 831
			sel_320: 150
			sel_349: 0
			sel_153: 165 124
			sel_63: 5
			sel_253: 180
		)
		(proc958_0 128 701 423 424)
		(proc958_0 132 16 662 700 49 452 453 455 80 701)
		(super sel_110:)
		(northDoor sel_110:)
		(elevatorShaft sel_110:)
		(backg sel_110:)
		(case1 sel_110:)
		(case2 sel_110:)
		(case3 sel_110:)
		(case4 sel_110:)
		(case5 sel_110:)
		(case6 sel_110:)
		(case7 sel_110:)
		(case8 sel_110:)
		(wall sel_110:)
		(pooh sel_110:)
		(caseDoor sel_110: sel_311: 4)
		(mummyDoor sel_110: sel_311: 4 38)
		(mummyDoorCase sel_110:)
		(snake sel_110: sel_311: 4)
		(mummy sel_110:)
		(gLb2WH sel_129: mummyDoorCase)
		(northDoor sel_161: End self)
		(sFXDoor sel_40: 46 sel_39:)
		(gListSel_109 sel_81: (northDoor sel_603?))
	)
	
	(method (sel_111)
		(gLb2WH sel_81: mummyDoorCase)
		(DisposeScript 2700)
		(gSel_608 sel_170:)
		(super sel_111:)
	)
	
	(method (sel_145)
		(if (== (backg sel_0?) 125)
			(northDoor sel_29: 2 sel_316: 1 sel_313:)
			(gEgo sel_63: -1 sel_312: MoveTo (gEgo sel_1?) 129 backg)
		else
			(if (global2 sel_365:) ((global2 sel_365:) sel_111:))
			(if (< (gEgo sel_0?) 123)
				(global2 sel_146: sCrushLaura)
			else
				(global2 sel_146: sKillRileyKill)
			)
		)
	)
	
	(method (sel_399)
		(rileyTimer sel_111: sel_81:)
		(super sel_399: &rest)
	)
)

(instance sGetMummy of Script
	(properties
		sel_20 {sGetMummy}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 185 137 self)
			)
			(1
				(gEgo
					sel_2: 702
					sel_155: 0
					sel_156: 0
					sel_161: CT 7 1 self
				)
			)
			(2
				(mummy sel_102:)
				(gEgo sel_161: End self)
			)
			(3
				(gEgo sel_350: 35 sel_585: 831 sel_3: 3)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sPutMummy of Script
	(properties
		sel_20 {sPutMummy}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 176 137 self)
			)
			(1
				(gEgo
					sel_2: 702
					sel_155: 1
					sel_156: 0
					sel_161: CT 5 1 self
				)
			)
			(2
				(sFX sel_40: 700 sel_99: 5 sel_3: 1 sel_39:)
				(gEgo sel_161: End self)
			)
			(3
				(mummy
					sel_216:
					sel_63: 7
					sel_153: 174 134 30
					sel_156: 0
					sel_313:
				)
				(gEgo sel_351: 35 sel_585: 831 sel_3: 3)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties
		sel_20 {sExitRoom}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 135 133 self)
			)
			(1
				(if
				(or (gEgo sel_238: 35) (not (== (mummy sel_4?) 0)))
					(rileyTimer sel_81: sel_111:)
					(global2 sel_146: sKillRileyKill)
				else
					(= sel_136 1)
				)
			)
			(2
				(gEgo sel_312: MoveTo 96 133 self)
			)
			(3
				(global2 sel_399: 710)
				(self sel_111:)
			)
		)
	)
)

(instance sUnlockCase of Script
	(properties
		sel_20 {sUnlockCase}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 135 139 self)
			)
			(1 (gEgo sel_253: 270 self))
			(2
				(gEgo
					sel_2: 700
					sel_155: 2
					sel_156: 0
					sel_63: 10
					sel_244: 12
					sel_161: CT 3 1 self
				)
			)
			(3
				(sFX sel_40: 49 sel_3: 1 sel_99: 5 sel_39:)
				(gEgo sel_161: End self)
			)
			(4 (gEgo sel_161: Beg self))
			(5
				(if local0
					(gLb2Messager sel_295: 15 0 1)
				else
					(gLb2Messager sel_295: 15 0 2)
					(= local0 1)
				)
				(gEgo sel_585: 831 sel_3: 1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCrushLaura of Script
	(properties
		sel_20 {sCrushLaura}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(proc958_0 132 500 490)
				(mummyDoor sel_317:)
				(caseDoor sel_317:)
				(northDoor sel_317:)
				(if
					(and
						(gSel_561 sel_122: mummy)
						(not (& (mummy sel_14?) $0008))
					)
					(mummy sel_317:)
				)
				(northDoor sel_316: 1)
				(gEgo sel_63: 2)
				(riley
					sel_110:
					sel_103: 1
					sel_104: 130
					sel_105: 130
					sel_155: 2
					sel_63: 5
					sel_312: MoveTo (riley sel_1?) 97
				)
				(backg sel_155: 5 sel_312: MoveTo (backg sel_1?) 97 self)
				(sFX sel_40: 662 sel_99: 1 sel_3: -1 sel_39:)
			)
			(1
				(sFX2 sel_40: 500 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo
					sel_2: 701
					sel_155: 1
					sel_156: 0
					sel_244: 12
					sel_161: End
				)
				(riley sel_312: MoveTo (riley sel_1?) 125)
				(backg
					sel_155: 5
					sel_312: MoveTo (backg sel_1?) 125 self
				)
			)
			(2
				(gSel_608 sel_167:)
				(sFX sel_167:)
				(sFX2 sel_167:)
				(sFX sel_40: 490 sel_3: 1 sel_99: 1 sel_39:)
				(backg sel_317:)
				(= sel_139 30)
			)
			(3
				(blood
					sel_110:
					sel_153: (+ (gEgo sel_1?) 13) (+ (gEgo sel_0?) 11)
					sel_161: End self
				)
			)
			(4 (= sel_139 180))
			(5
				(= global145 4)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sKillRileyKill of Script
	(properties
		sel_20 {sKillRileyKill}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(if (northDoor sel_4?)
					(gSel_608 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				)
				(northDoor sel_316: 1)
				(mummyDoor sel_317:)
				(caseDoor sel_317:)
				(if
					(and
						(gSel_561 sel_122: mummy)
						(not (& (mummy sel_14?) $0008))
					)
					(mummy sel_317:)
				)
				(riley
					sel_110:
					sel_103: 1
					sel_104: 130
					sel_105: 130
					sel_155: 2
					sel_63: 5
					sel_312: MoveTo (riley sel_1?) 125
				)
				(backg
					sel_155: 5
					sel_312: MoveTo (backg sel_1?) 125 self
				)
				(sFX sel_40: 662 sel_99: 1 sel_3: -1 sel_39:)
			)
			(1
				(= sel_141 0)
				(sFX sel_167:)
				(backg sel_317:)
				(if (northDoor sel_4?)
					(= sel_136 1)
				else
					(northDoor sel_161: End self)
					(sFXDoor sel_40: 46 sel_39:)
					(= sel_141 1)
					(gListSel_109 sel_81: (northDoor sel_603?))
				)
			)
			(2
				(if sel_141
					(gSel_608 sel_40: 3 sel_3: 1 sel_99: 1 sel_39:)
				)
				(northDoor sel_317:)
				(riley sel_63: -1)
				(gEgo sel_312: PolyPath 120 143 self)
			)
			(3
				(gEgo sel_253: 90)
				(riley
					sel_161: Walk
					sel_320: 130
					sel_312: MoveTo 145 148 self
				)
			)
			(4 (riley sel_253: 270 self))
			(5
				(gEgo
					sel_2: 700
					sel_155: 6
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(6
				(riley
					sel_2: 424
					sel_155: 1
					sel_156: 0
					sel_161: CT 6 1 self
				)
			)
			(7
				(sFX sel_40: 80 sel_99: 5 sel_3: 1 sel_39:)
				(riley sel_161: End self)
			)
			(8
				(gEgo
					sel_2: 701
					sel_155: 1
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(9 (= sel_139 120))
			(10
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sListen of Script
	(properties
		sel_20 {sListen}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gGameMusic2
					sel_40: 701
					sel_3: -1
					sel_99: 5
					sel_172: 63
					sel_39:
				)
				(= sel_136 1)
			)
			(1
				(gLb2Messager sel_295: 14 38)
				(= sel_136 1)
			)
			(2
				(gGameMusic2 sel_170:)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance backg of Actor
	(properties
		sel_20 {backg}
		sel_1 166
		sel_0 125
		sel_2 700
		sel_3 5
		sel_60 4
		sel_14 16400
	)
	
	(method (sel_145)
		(if (== sel_0 125)
			(self sel_155: 5 sel_312: MoveTo (self sel_1?) 79 self)
			(gSel_608 sel_40: 16 sel_99: 1 sel_3: -1 sel_39:)
			(sFX sel_40: 662 sel_99: 1 sel_3: -1 sel_39:)
		else
			(sFX sel_167:)
			(rileyTimer sel_162: global2 0 1)
			(global2 sel_135: rileyTimer)
			(self sel_313:)
			(gGame sel_588:)
		)
	)
)

(instance riley of Actor
	(properties
		sel_20 {riley}
		sel_1 167
		sel_0 79
		sel_2 423
		sel_3 2
		sel_4 4
		sel_14 16384
	)
)

(instance rileyTimer of Timer
	(properties
		sel_20 {rileyTimer}
	)
)

(instance northDoor of Door
	(properties
		sel_20 {northDoor}
		sel_1 152
		sel_0 101
		sel_82 21
		sel_213 1
		sel_303 166
		sel_304 137
		sel_2 700
		sel_3 1
		sel_589 660
		sel_596 0
		sel_597 166
		sel_598 108
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (!= (mummy sel_4?) 0) (super sel_300: param1))
			)
			(9
				(if (self sel_4?)
					(super sel_300: param1)
				else
					(rileyTimer sel_81: sel_111:)
					(global2 sel_146: sPutMummy)
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_606)
		(super sel_606: 148 117 185 117 186 126 148 126)
	)
)

(instance inPooh of Inset
	(properties
		sel_20 {inPooh}
		sel_2 700
		sel_3 4
		sel_1 204
		sel_0 77
		sel_570 1
		sel_213 18
	)
)

(instance mummyDoor of Prop
	(properties
		sel_20 {mummyDoor}
		sel_1 120
		sel_0 126
		sel_213 14
		sel_303 138
		sel_304 139
		sel_2 700
		sel_60 10
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					((self sel_4?)
						(sFX sel_40: 453 sel_3: 1 sel_99: 5 sel_39:)
						(self sel_161: Beg self)
						(snake sel_110:)
					)
					(local0
						(sFX sel_40: 452 sel_3: 1 sel_99: 5 sel_39:)
						(self sel_161: End self)
						(snake sel_111:)
					)
					(else (gLb2Messager sel_295: 14 4 1))
				)
			)
			(38
				(if (not sel_4) (global2 sel_146: sListen))
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(if (self sel_4?)
			(self sel_63: 7 sel_313:)
			(sFX sel_167:)
		else
			(sFX sel_40: 455 sel_3: 1 sel_99: 5 sel_39:)
			(self sel_63: 10 sel_313:)
		)
	)
)

(instance caseDoor of Prop
	(properties
		sel_20 {caseDoor}
		sel_1 239
		sel_0 128
		sel_213 8
		sel_303 172
		sel_304 135
		sel_2 700
		sel_3 3
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (self sel_4?)
					(sFX sel_40: 453 sel_3: 1 sel_99: 5 sel_39:)
					(self sel_161: Beg self)
					(= sel_0 (- sel_0 100))
					(= sel_82 (- sel_82 100))
				else
					(sFX sel_40: 452 sel_3: 1 sel_99: 5 sel_39:)
					(self sel_161: End self)
					(= sel_0 (+ sel_0 100))
					(= sel_82 (+ sel_82 100))
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(self sel_313:)
		(if sel_4
			(sFX sel_167:)
		else
			(sFX sel_40: 455 sel_3: 1 sel_99: 5 sel_39:)
		)
	)
)

(instance blood of Prop
	(properties
		sel_20 {blood}
		sel_2 701
		sel_3 2
		sel_244 15
	)
)

(instance mummy of View
	(properties
		sel_20 {mummy}
		sel_1 187
		sel_0 122
		sel_213 11
		sel_2 702
		sel_3 2
		sel_4 1
		sel_60 10
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (== (mummy sel_4?) 0)
					(super sel_300: param1)
				else
					(global2 sel_146: sGetMummy)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance pooh of Feature
	(properties
		sel_20 {pooh}
		sel_1 228
		sel_0 96
		sel_6 90
		sel_7 223
		sel_8 103
		sel_9 234
		sel_301 40
		sel_303 178
		sel_304 133
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (caseDoor sel_4?)
					(global2 sel_422: inPooh)
				else
					(caseDoor sel_300: 1)
				)
			)
			(8
				(if (caseDoor sel_4?)
					(global2 sel_422: inPooh)
				else
					(caseDoor sel_300: 8)
				)
			)
			(4
				(if (caseDoor sel_4?)
					(super sel_300: param1)
				else
					(caseDoor sel_300: 4)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance mummyDoorCase of Feature
	(properties
		sel_20 {mummyDoorCase}
		sel_1 115
		sel_0 100
		sel_213 16
		sel_6 79
		sel_7 98
		sel_8 133
		sel_9 118
		sel_301 40
		sel_303 135
		sel_304 133
	)
	
	(method (sel_300 param1)
		(switch param1
			(3
				(if (and local0 (mummyDoor sel_4?))
					(global2 sel_146: sExitRoom)
				else
					(super sel_300: param1)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance snake of Feature
	(properties
		sel_20 {snake}
		sel_0 127
		sel_213 15
		sel_6 75
		sel_7 117
		sel_8 86
		sel_9 127
		sel_301 40
		sel_303 139
		sel_304 139
	)
	
	(method (sel_300 param1)
		(switch param1
			(30
				(global2 sel_146: sUnlockCase)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance elevatorShaft of Feature
	(properties
		sel_20 {elevatorShaft}
		sel_1 167
		sel_0 100
		sel_213 12
		sel_6 80
		sel_7 154
		sel_8 121
		sel_9 180
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (northDoor sel_4?)
					(gLb2Messager sel_295: 12 1)
				else
					(super sel_300: param1)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance case1 of Feature
	(properties
		sel_20 {case1}
		sel_0 1
		sel_213 2
		sel_302 8
	)
)

(instance case2 of Feature
	(properties
		sel_20 {case2}
		sel_0 1
		sel_213 3
		sel_302 4
	)
)

(instance case3 of Feature
	(properties
		sel_20 {case3}
		sel_0 1
		sel_213 4
		sel_302 16
	)
)

(instance case4 of Feature
	(properties
		sel_20 {case4}
		sel_0 1
		sel_213 5
		sel_302 32
	)
)

(instance case5 of Feature
	(properties
		sel_20 {case5}
		sel_0 1
		sel_213 6
		sel_302 64
	)
)

(instance case6 of Feature
	(properties
		sel_20 {case6}
		sel_0 1
		sel_213 7
		sel_302 128
	)
)

(instance case7 of Feature
	(properties
		sel_20 {case7}
		sel_0 1
		sel_213 20
		sel_302 256
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (caseDoor sel_4?)
					(super sel_300: param1)
				else
					(caseDoor sel_300: 1)
				)
			)
			(8
				(if (caseDoor sel_4?)
					(super sel_300: param1)
				else
					(caseDoor sel_300: 8)
				)
			)
			(4
				(if (caseDoor sel_4?)
					(super sel_300: param1)
				else
					(caseDoor sel_300: 4)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance case8 of Feature
	(properties
		sel_20 {case8}
		sel_0 1
		sel_213 9
		sel_302 512
	)
)

(instance wall of Feature
	(properties
		sel_20 {wall}
		sel_0 1
		sel_213 10
		sel_302 1024
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
		sel_3 -1
	)
)

(instance sFX2 of Sound
	(properties
		sel_20 {sFX2}
		sel_99 1
	)
)

(instance sFXDoor of Sound
	(properties
		sel_20 {sFXDoor}
		sel_99 5
	)
)
