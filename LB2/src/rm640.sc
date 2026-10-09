;;; Sierra Script 1.0 - (do not remove this comment)
(script# 640)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use Inset)
(use PolyPath)
(use CueObj)
(use ForwardCounter)
(use n958)
(use Timer)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm640 0
	westDoor 4
)

(local
	local0
	local1
	local2
	local3
)
(instance rm640 of LBRoom
	(properties
		sel_20 {rm640}
		sel_213 29
		sel_408 640
		sel_412 610
		sel_108 85
	)
	
	(method (sel_110)
		(gEgo sel_110: sel_585: 831 sel_320: 155)
		(self sel_414: 90)
		(switch gGSel_40
			(sel_412
				(gEgo sel_349: 0 sel_253: 90)
			)
			(else 
				(gEgo sel_584: 1 sel_153: 160 160)
				(proc0_3 4)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(proc958_0 132 640 641 643)
		(westDoor sel_110:)
		(if (not (proc0_2 4))
			(Load rsVIEW 646)
			(cond 
				((not (proc0_10 -20222))
					(Load rsPIC 645)
					(gGameMusic2 sel_40: 551 sel_99: 1 sel_3: -1 sel_39:)
					(ernie_Yvette sel_110: sel_244: 42 sel_161: Fwd)
					(proc0_3 18)
					(toolBoxClosed sel_110:)
					(desk sel_110:)
					(underDesk sel_110:)
					(intercom sel_110:)
					(mopBucket sel_110:)
					(bear sel_110:)
					(skeleton sel_110:)
					(brooms sel_110:)
					(block sel_110:)
					(blotchOnWall sel_110:)
					(light sel_110:)
					(nautilus sel_110:)
					(nefertiti sel_110:)
					(squirrel sel_110:)
					(heads sel_110:)
					(beam1 sel_110:)
					(beam2 sel_110:)
					(leftStuff sel_110:)
					(rightStuff sel_110:)
					(rightmostStuff sel_110:)
					(blender sel_110:)
					(snakeLasso sel_311: 4 1 8 sel_110:)
				)
				((not (proc0_10 4880))
					(gGameMusic2 sel_40: 642 sel_99: 1 sel_3: -1 sel_39:)
					(if (or (proc0_2 15) (Random 0 1))
						(proc958_0 128 642 643)
						(toolBoxClosed sel_110: sel_311: 4)
						(toolBoxOpen sel_110: sel_311: 4 1)
						(if (not (proc0_2 19)) (toolBoxOpen sel_102:))
						(if (not (gEgo sel_238: 19))
							(snakeLasso sel_311: 4 1 8 sel_110:)
						)
						(desk sel_110: sel_311: 1 8)
						(underDesk sel_110: sel_311: 1 8)
						(intercom sel_110:)
						(mopBucket sel_110:)
						(bear sel_110:)
						(skeleton sel_110:)
						(brooms sel_110:)
						(block sel_110:)
						(blotchOnWall
							sel_156: (if (proc0_2 119) (blotchOnWall sel_246:) else 0)
							sel_311: 4
							sel_110:
						)
						(light sel_110:)
						(nautilus sel_110:)
						(nefertiti sel_110:)
						(squirrel sel_110:)
						(heads sel_110:)
						(beam1 sel_110:)
						(beam2 sel_110:)
						(leftStuff sel_110:)
						(rightStuff sel_110:)
						(rightmostStuff sel_110:)
						(blender sel_110:)
					else
						((ScriptID 31 0)
							sel_110:
							sel_2: 824
							sel_620: gSel_40
							sel_63: 9
							sel_153: 108 140
							sel_253: 90
						)
						(proc0_3 18)
						(= local0 1)
					)
				)
				(else
					(Load rsPIC 645)
					(gGameMusic2 sel_40: 551 sel_99: 1 sel_3: -1 sel_39:)
					(ernie_Yvette
						sel_110:
						sel_155: 1
						sel_244: 42
						sel_161: Fwd
					)
					(proc0_3 18)
				)
			)
		else
			(proc958_0 128 642 643)
			(gGameMusic2 sel_40: 642 sel_99: 1 sel_3: -1 sel_39:)
			(toolBoxClosed sel_110: sel_311: 4)
			(toolBoxOpen sel_110: sel_311: 4 1)
			(if (not (proc0_2 19)) (toolBoxOpen sel_102:))
			(desk sel_110: sel_311: 1 8)
			(underDesk sel_110: sel_311: 1 8)
			(if (not (gEgo sel_238: 19))
				(snakeLasso sel_311: 4 1 8 sel_110:)
			)
			(intercom sel_110:)
			(mopBucket sel_110:)
			(bear sel_110:)
			(skeleton sel_110:)
			(brooms sel_110:)
			(block sel_110:)
			(blotchOnWall
				sel_156: (if (proc0_2 119) (blotchOnWall sel_246:) else 0)
				sel_311: 4
				sel_110:
			)
			(light sel_110:)
			(nautilus sel_110:)
			(nefertiti sel_110:)
			(squirrel sel_110:)
			(heads sel_110:)
			(beam1 sel_110:)
			(beam2 sel_110:)
			(leftStuff sel_110:)
			(rightStuff sel_110:)
			(rightmostStuff sel_110:)
			(blender sel_110:)
		)
	)
	
	(method (sel_111)
		(if (gLb2WH sel_122: global2) (gLb2WH sel_81: global2))
		(if (not (proc0_2 18)) (proc0_3 15) else (proc0_4 15))
		(ernieTimer sel_111: sel_81:)
		(gGameMusic2 sel_170:)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(3
				(if local3
					(roomActions sel_300:)
				else
					(global2 sel_146: sKickOut)
				)
			)
			(else 
				(if local3
					(roomActions sel_300:)
				else
					(super sel_300: param1)
				)
			)
		)
	)
	
	(method (sel_145)
		(if (or sel_142 sel_365 (westDoor sel_4?))
			(ernieTimer sel_162: self 10)
		else
			(global2 sel_146: sErnieKickOut)
		)
	)
)

(instance sEnterErnie1 of Script
	(properties
		sel_20 {sEnterErnie1}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 46)
				(ernie_Yvette sel_161: ForwardCounter 2 self)
			)
			(1
				(gSel_561 sel_119: 102)
				(global2 sel_417: 645 9)
				(= sel_137 4)
			)
			(2
				(global2 sel_417: 640 9)
				(gSel_561 sel_119: 216)
				(= sel_139 90)
			)
			(3
				(ernie_Yvette
					sel_155: 2
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(4
				(gLb2Messager sel_295: 27 0 1)
				(= sel_136 1)
			)
			(5
				(gLb2WH sel_129: global2)
				(gSel_561 sel_119: 299 roomActions)
				(westDoor sel_299: 0)
				(gSel_562 sel_119: 299 roomActions)
				(= local3 1)
				(gGame sel_588:)
				(= sel_137 15)
			)
			(6
				(global2 sel_146: sKickOut)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterErnie2 of Script
	(properties
		sel_20 {sEnterErnie2}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 0)
				(ernie_Yvette sel_161: ForwardCounter 2 self)
			)
			(1
				(gSel_561 sel_119: 102)
				(global2 sel_417: 645 9)
				(= sel_137 4)
			)
			(2
				(global2 sel_417: 640 9)
				(gSel_561 sel_119: 216)
				(= sel_139 90)
			)
			(3
				(ernie_Yvette
					sel_155: 2
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(4
				(gLb2Messager sel_295: 27 0 2)
				(= sel_139 60)
			)
			(5 (gEgo sel_253: 180 self))
			(6
				(gEgo
					sel_2: 646
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(7
				(gEgo sel_585: 831 sel_3: 2)
				(westDoor sel_300: 4)
				(self sel_111:)
			)
		)
	)
)

(instance sErnieAloneKick of Script
	(properties
		sel_20 {sErnieAloneKick}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 31 0) sel_155: 7 sel_156: 4)
				(= sel_136 4)
			)
			(1
				((ScriptID 31 0) sel_156: 2)
				(= sel_136 1)
			)
			(2
				(if (Random 0 1)
					(gLb2Messager sel_295: 27 0 3)
				else
					(gLb2Messager sel_295: 27 0 6)
				)
				(= sel_139 60)
			)
			(3 (gEgo sel_253: 180 self))
			(4
				(gEgo
					sel_2: 646
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(5
				(gEgo sel_585: 831 sel_3: 2)
				(proc0_3 18)
				(westDoor sel_300: 4)
				(self sel_111:)
			)
		)
	)
)

(instance sErnieAloneAsk of Script
	(properties
		sel_20 {sErnieAloneAsk}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 31 0) sel_155: 7 sel_156: 4)
				(= sel_136 4)
			)
			(1
				((ScriptID 31 0) sel_156: 2)
				(= sel_136 1)
			)
			(2
				(gLb2Messager sel_295: 30)
				(= sel_136 1)
			)
			(3
				(gLb2WH sel_129: global2)
				(gSel_561 sel_119: 299 roomActions)
				(westDoor sel_299: 0)
				((ScriptID 31 0) sel_299: ernieActions)
				(gSel_562 sel_119: 299 roomActions)
				(= local3 1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sErnieKickOut of Script
	(properties
		sel_20 {sErnieKickOut}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				((ScriptID 31 0)
					sel_110:
					sel_2: 824
					sel_620: gSel_40
					sel_153: (westDoor sel_597?) (westDoor sel_598?)
					sel_253: 90
				)
				(westDoor sel_189:)
			)
			(1
				(if
				(and (< (gEgo sel_1?) 127) (< (gEgo sel_0?) 165))
					(gEgo sel_312: PolyPath 124 160 self)
				else
					(= sel_136 1)
				)
			)
			(2
				(proc0_5
					gEgo
					(+ (westDoor sel_303?) 30)
					(westDoor sel_304?)
				)
				((ScriptID 31 0)
					sel_312: PolyPath (+ (westDoor sel_303?) 30) (westDoor sel_304?) self
				)
			)
			(3
				(proc0_5 (ScriptID 31 0) gEgo)
				(westDoor sel_360:)
			)
			(4
				(cond 
					((proc0_2 96) (gLb2Messager sel_295: 27 0 10))
					((proc0_2 95) (gLb2Messager sel_295: 27 0 9) (proc0_3 96))
					(else (gLb2Messager sel_295: 27 0 8) (proc0_3 95))
				)
				(= sel_136 1)
			)
			(5
				(gEgo
					sel_312: PolyPath (westDoor sel_303?) (westDoor sel_304?) self
				)
			)
			(6
				(proc0_3 18)
				(westDoor sel_300: 4)
				(self sel_111:)
			)
		)
	)
)

(instance sKickOut of Script
	(properties
		sel_20 {sKickOut}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 0)
				(= sel_136 1)
			)
			(1
				(if local2
					(gLb2Messager sel_295: 27 0 6)
				else
					(gLb2Messager sel_295: 27 0 4)
				)
				(= sel_139 60)
			)
			(2 (gEgo sel_253: 180 self))
			(3
				(gEgo
					sel_2: 646
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(4
				(gEgo sel_585: 831 sel_3: 2)
				(westDoor sel_300: 4)
				(proc0_3 18)
				(self sel_111:)
			)
		)
	)
)

(instance sPlayIntercom of Script
	(properties
		sel_20 {sPlayIntercom}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 3))
			(1
				(gLb2Messager sel_295: 4 0 5)
				(= sel_136 1)
			)
			(2
				(proc0_3 17)
				(self sel_111:)
			)
		)
	)
)

(instance sGetWireCutters of Script
	(properties
		sel_20 {sGetWireCutters}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 642
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(1
				(gEgo sel_155: 1 sel_156: 0 sel_161: End self)
			)
			(2 (gEgo sel_161: Beg self))
			(3
				(gEgo
					sel_155: 0
					sel_156: (gEgo sel_246:)
					sel_161: Beg self
				)
			)
			(4
				(gEgo sel_350: 10 sel_585: 831 sel_3: 1)
				((ScriptID 21 0) sel_57: 779)
				(gGame sel_87: 1 145)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLookLasso of Script
	(properties
		sel_20 {sLookLasso}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_253: 270 self)
			)
			(1
				(gEgo
					sel_2: 643
					sel_155: 0
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(2 (= sel_139 60))
			(3 (gEgo sel_161: Beg self))
			(4
				(if (gEgo sel_238: 19)
					(gLb2Messager sel_295: 24 1)
				else
					(global2 sel_422: inSnakeLasso)
				)
				(gEgo sel_585: 831 sel_3: 1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetLasso of Script
	(properties
		sel_20 {sGetLasso}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 643
					sel_155: 3
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(1
				(snakeLasso sel_111:)
				(= sel_139 30)
			)
			(2 (gEgo sel_161: Beg self))
			(3
				(gEgo sel_350: 19 sel_585: 831 sel_3: 1)
				((ScriptID 21 0) sel_57: 788)
				(gGame sel_87: 1 141)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLookWireCutters of Script
	(properties
		sel_20 {sLookWireCutters}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo sel_312: PolyPath 32 172 self)
			)
			(1
				(global2 sel_422: inWireCutter)
				(self sel_111:)
			)
		)
	)
)

(instance sBlotchTime of Script
	(properties
		sel_20 {sBlotchTime}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 640
					sel_155: 7
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(1 (= sel_139 20))
			(2
				(gEgo sel_161: Beg)
				(blotchOnWall sel_161: End self)
				(sFX sel_40: 558 sel_3: 1 sel_99: 5 sel_39:)
			)
			(3
				(sFX sel_40: 721 sel_3: -1 sel_99: 5 sel_39:)
				(proc0_3 119)
				(= sel_139 180)
			)
			(4
				(sFX sel_167:)
				(= sel_136 1)
			)
			(5
				(gEgo sel_585: 831 sel_3: 1)
				(gLb2Messager sel_295: 10 4 11)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance blotchOnWall of Prop
	(properties
		sel_20 {blotchOnWall}
		sel_1 54
		sel_0 103
		sel_213 10
		sel_303 66
		sel_304 145
		sel_2 640
		sel_3 6
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (proc0_2 119)
					(gLb2Messager sel_295: 10 1 12)
				else
					(gLb2Messager sel_295: 10 1 11)
				)
			)
			(4
				(if (proc0_2 119)
					(gLb2Messager sel_295: 10 4 12)
				else
					(global2 sel_146: sBlotchTime)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance ernie_Yvette of Prop
	(properties
		sel_20 {ernie&Yvette}
		sel_1 113
		sel_0 143
		sel_2 641
		sel_14 16385
		sel_244 12
		name "ernie&Yvette"
	)
)

(instance roomActions of Actions
	(properties
		sel_20 {roomActions}
	)
	
	(method (sel_300)
		(if local1
			(gLb2Messager sel_295: 30 0 7)
			(= local1 0)
			(= local2 1)
		else
			(global2 sel_146: sKickOut)
		)
	)
)

(instance ernieActions of Actions
	(properties
		sel_20 {ernieActions}
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 1 1 24 0 0 1893)
			)
			(4
				(gLb2Messager sel_295: 1 4 24 0 0 1893)
			)
			(2
				(gLb2Messager sel_295: 1 2 24 0 0 1893)
			)
			(else  0)
		)
	)
)

(instance westDoor of Door
	(properties
		sel_20 {westDoor}
		sel_1 38
		sel_0 94
		sel_213 1
		sel_303 70
		sel_304 152
		sel_2 640
		sel_3 5
		sel_60 10
		sel_14 16
		sel_589 610
		sel_597 12
		sel_598 143
		sel_599 0
		sel_600 0
	)
	
	(method (sel_145)
		(if (== (global2 sel_142?) sErnieKickOut)
			(if (== sel_29 1) (gListSel_109 sel_81: sel_603))
			(sErnieKickOut sel_145:)
		else
			(super sel_145:)
			(if (== sel_29 0)
				(gIconBar sel_177: 7)
				(cond 
					((proc0_2 4)
						(if (and (not (proc0_2 17)) (not (proc0_2 22)))
							(global2 sel_146: sPlayIntercom)
						)
					)
					((not (proc0_10 -20222)) (global2 sel_146: sEnterErnie1))
					((not (proc0_10 -15612))
						(if local0
							(global2 sel_146: sErnieAloneKick)
						else
							(ernieTimer
								sel_162: global2 (if (proc0_2 96) 30 else 60)
							)
							(if (and (not (proc0_2 17)) (not (proc0_2 22)))
								(global2 sel_146: sPlayIntercom)
							)
						)
					)
					((not (proc0_10 4880))
						(if local0
							(= local1 1)
							(global2 sel_146: sErnieAloneAsk)
						else
							(ernieTimer
								sel_162: global2 (if (proc0_2 96) 30 else 60)
							)
							(if (and (not (proc0_2 17)) (not (proc0_2 22)))
								(global2 sel_146: sPlayIntercom)
							)
						)
					)
					(else (global2 sel_146: sEnterErnie2))
				)
			)
		)
	)
	
	(method (sel_606)
		(super sel_606: 13 150 40 138 47 145 22 155)
	)
)

(instance toolBoxOpen of View
	(properties
		sel_20 {toolBoxOpen}
		sel_1 1
		sel_0 150
		sel_213 2
		sel_303 32
		sel_304 172
		sel_2 640
		sel_60 13
		sel_14 17
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (gEgo sel_238: 10)
					(super sel_300: param1)
				else
					(global2 sel_422: inWireCutter)
				)
			)
			(4
				(self sel_102:)
				(proc0_4 19)
				(sFX sel_40: 641 sel_3: 1 sel_99: 5 sel_39:)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance snakeLasso of View
	(properties
		sel_20 {snakeLasso}
		sel_1 118
		sel_0 140
		sel_303 136
		sel_304 143
		sel_2 640
		sel_3 8
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (self sel_299?)
					0
				else
					(global2 sel_146: sLookLasso)
				)
			)
			(8 (self sel_300: 1))
			(4 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance inWireCutter of Inset
	(properties
		sel_20 {inWireCutter}
		sel_2 640
		sel_3 4
		sel_0 133
		sel_570 1
		sel_213 22
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sGetWireCutters)
				(self sel_111:)
			)
			(1
				(gLb2Messager sel_295: 38 1 0 0 0 15)
			)
			(8
				(gLb2Messager sel_295: 38 8 0 0 0 15)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inSnakeLasso of Inset
	(properties
		sel_20 {inSnakeLasso}
		sel_2 640
		sel_3 1
		sel_1 81
		sel_0 116
		sel_570 1
		sel_213 23
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sGetLasso)
				(self sel_111:)
			)
			(1
				(gLb2Messager sel_295: 32 1 0 0 0 15)
			)
			(8
				(gLb2Messager sel_295: 32 8 0 0 0 15)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inVatBook of Inset
	(properties
		sel_20 {inVatBook}
		sel_2 640
		sel_3 2
		sel_1 53
		sel_0 100
		sel_570 1
		sel_213 25
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_422: inVatBookOpen)
			)
			(8 (gLb2Messager sel_295: 25 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance inVatBookOpen of Inset
	(properties
		sel_20 {inVatBookOpen}
		sel_2 640
		sel_3 3
		sel_1 53
		sel_0 100
		sel_570 1
		sel_213 26
	)
	
	(method (sel_300 param1)
		(switch param1
			(8 (gLb2Messager sel_295: 26 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance toolBoxClosed of Feature
	(properties
		sel_20 {toolBoxClosed}
		sel_1 15
		sel_0 163
		sel_213 2
		sel_6 156
		sel_7 5
		sel_8 170
		sel_9 25
		sel_301 40
		sel_303 32
		sel_304 172
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (and (proc0_2 19) (not (gEgo sel_238: 10)))
					(global2 sel_146: sLookWireCutters)
				else
					(super sel_300: param1)
				)
			)
			(4
				(if (proc0_2 19)
					(toolBoxOpen sel_102:)
					(proc0_4 19)
					(sFX sel_40: 641 sel_3: 1 sel_99: 5 sel_39:)
				else
					(toolBoxOpen sel_216: sel_313:)
					(proc0_3 19)
					(sFX sel_40: 640 sel_3: 1 sel_99: 5 sel_39:)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_1 79
		sel_0 134
		sel_213 3
		sel_6 123
		sel_7 43
		sel_8 145
		sel_9 116
		sel_301 40
		sel_303 79
		sel_304 156
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (self sel_299?) 0 else (global2 sel_422: inVatBook))
			)
			(8 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance underDesk of Feature
	(properties
		sel_20 {underDesk}
		sel_1 80
		sel_0 144
		sel_213 24
		sel_6 136
		sel_7 46
		sel_8 147
		sel_9 115
		sel_303 136
		sel_304 143
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if (self sel_299?)
					0
				else
					(global2 sel_146: sLookLasso)
				)
			)
			(8 (self sel_300: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance intercom of Feature
	(properties
		sel_20 {intercom}
		sel_1 54
		sel_0 122
		sel_213 4
		sel_6 119
		sel_7 47
		sel_8 126
		sel_9 62
		sel_301 40
	)
)

(instance mopBucket of Feature
	(properties
		sel_20 {mopBucket}
		sel_1 238
		sel_0 133
		sel_213 5
		sel_6 108
		sel_7 231
		sel_8 158
		sel_9 246
		sel_301 40
	)
)

(instance bear of Feature
	(properties
		sel_20 {bear}
		sel_1 285
		sel_0 146
		sel_213 6
		sel_6 104
		sel_7 251
		sel_8 189
		sel_9 319
		sel_301 40
		sel_302 4
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(sFX sel_40: 643 sel_3: 1 sel_99: 1 sel_39:)
				(gLb2Messager sel_295: 6 4)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance skeleton of Feature
	(properties
		sel_20 {skeleton}
		sel_1 199
		sel_0 154
		sel_213 7
		sel_6 119
		sel_7 166
		sel_8 189
		sel_9 233
		sel_301 40
		sel_302 2
	)
)

(instance brooms of Feature
	(properties
		sel_20 {brooms}
		sel_1 8
		sel_0 118
		sel_213 8
		sel_6 91
		sel_8 146
		sel_9 16
		sel_301 40
	)
)

(instance block of Feature
	(properties
		sel_20 {block}
		sel_1 235
		sel_0 172
		sel_213 9
		sel_6 156
		sel_7 203
		sel_8 189
		sel_9 268
		sel_301 40
		sel_302 8
	)
)

(instance light of Feature
	(properties
		sel_20 {light}
		sel_1 151
		sel_0 80
		sel_213 11
		sel_6 74
		sel_7 142
		sel_8 86
		sel_9 160
		sel_301 40
		sel_302 16
	)
)

(instance nautilus of Feature
	(properties
		sel_20 {nautilus}
		sel_1 140
		sel_0 121
		sel_213 12
		sel_6 111
		sel_7 133
		sel_8 132
		sel_9 147
		sel_301 40
	)
)

(instance nefertiti of Feature
	(properties
		sel_20 {nefertiti}
		sel_1 196
		sel_0 183
		sel_82 100
		sel_213 21
		sel_6 73
		sel_7 184
		sel_8 93
		sel_9 208
		sel_301 40
	)
)

(instance squirrel of Feature
	(properties
		sel_20 {squirrel}
		sel_1 299
		sel_0 32
		sel_213 14
		sel_6 11
		sel_7 279
		sel_8 54
		sel_9 319
		sel_301 40
	)
)

(instance heads of Feature
	(properties
		sel_20 {heads}
		sel_1 299
		sel_0 81
		sel_213 15
		sel_6 56
		sel_7 279
		sel_8 107
		sel_9 319
		sel_301 40
	)
)

(instance beam1 of Feature
	(properties
		sel_20 {beam1}
		sel_1 138
		sel_0 16
		sel_213 16
		sel_6 10
		sel_8 22
		sel_9 276
		sel_301 40
	)
)

(instance beam2 of Feature
	(properties
		sel_20 {beam2}
		sel_1 142
		sel_0 51
		sel_213 17
		sel_6 46
		sel_7 49
		sel_8 56
		sel_9 235
		sel_301 40
	)
)

(instance leftStuff of Feature
	(properties
		sel_20 {leftStuff}
		sel_1 114
		sel_0 96
		sel_213 18
		sel_6 74
		sel_7 87
		sel_8 119
		sel_9 142
		sel_301 40
	)
)

(instance rightStuff of Feature
	(properties
		sel_20 {rightStuff}
		sel_1 184
		sel_0 95
		sel_213 19
		sel_6 72
		sel_7 159
		sel_8 118
		sel_9 209
		sel_301 40
	)
)

(instance rightmostStuff of Feature
	(properties
		sel_20 {rightmostStuff}
		sel_1 246
		sel_0 87
		sel_213 20
		sel_6 30
		sel_7 210
		sel_8 107
		sel_9 279
		sel_301 40
		sel_302 32
	)
)

(instance blender of Feature
	(properties
		sel_20 {blender}
		sel_0 97
		sel_213 28
		sel_6 75
		sel_7 97
		sel_8 95
		sel_9 109
		sel_301 40
	)
)

(instance ernieTimer of Timer
	(properties
		sel_20 {ernieTimer}
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
