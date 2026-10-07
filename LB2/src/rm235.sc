;;; Sierra Script 1.0 - (do not remove this comment)
(script# 235)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use CueObj)
(use Sound)
(use View)
(use Obj)

(public
	rm235 0
)

(local
	local0 =  1
)
(instance rm235 of LBRoom
	(properties
		sel_20 {rm235}
		sel_214 230
		sel_213 24
		sel_408 235
	)
	
	(method (sel_110)
		(Load rsVIEW 235)
		(super sel_110:)
		(closeupBlotterLF sel_110:)
		(closeupBlotterLB sel_110:)
		(closeupBlotterRF sel_110:)
		(closeupBlotterRB sel_110:)
		(pencilHolder sel_110:)
		(drawer sel_110:)
		(restOfBlotter sel_110:)
		(if (proc0_2 29) (keyInDrawerC sel_110:))
		(proc0_8 1)
		(gGame sel_588:)
	)
	
	(method (sel_111)
		(proc0_8 0)
		(super sel_111:)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 24 1 0 0 0 230)
			)
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance sLiftMat of Script
	(properties
		sel_20 {sLiftMat}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(switch sel_141
					(0
						(if (gSel_561 sel_122: cornerUpLF)
							(cornerUpLF sel_111:)
						else
							(cornerUpLF sel_110:)
						)
					)
					(1
						(if (gSel_561 sel_122: cornerUpLB)
							(cornerUpLB sel_111:)
						else
							(cornerUpLB sel_110:)
						)
					)
					(2
						(if (gSel_561 sel_122: cornerUpRF)
							(cornerUpRF sel_111:)
							(keyUnder sel_111:)
						else
							(if
							(and (not (gEgo sel_238: 5)) (not (proc0_2 29)))
								(keyUnder sel_110:)
							)
							(cornerUpRF sel_110:)
						)
					)
					(3
						(if (gSel_561 sel_122: cornerUpRB)
							(cornerUpRB sel_111:)
						else
							(cornerUpRB sel_110:)
						)
					)
				)
				(= sel_136 1)
			)
			(1
				(cond 
					(
					(and (gSel_561 sel_122: cornerUpRF) (== sel_141 2))
						(if
						(and (not (gEgo sel_238: 5)) (not (proc0_2 29)))
							(gLb2Messager sel_295: 10 4 1 0 self 230)
						else
							(gLb2Messager sel_295: 10 4 2 0 self 230)
						)
					)
					(
					(and (gSel_561 sel_122: cornerUpRB) (== sel_141 3)) (gLb2Messager sel_295: 10 4 2 0 self 230))
					(
					(and (gSel_561 sel_122: cornerUpLB) (== sel_141 1)) (gLb2Messager sel_295: 10 4 2 0 self 230))
					(
					(and (gSel_561 sel_122: cornerUpLF) (== sel_141 0)) (gLb2Messager sel_295: 10 4 2 0 self 230))
					(else (= sel_136 1))
				)
			)
			(2 (self sel_111:))
		)
	)
)

(instance sUseKeyOnDrawer of Script
	(properties
		sel_20 {sUseKeyOnDrawer}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(= local0 0)
				(gEgo sel_351: 5)
				((ScriptID 21 1) sel_57: 774)
				(proc0_3 29)
				(gLb2Messager sel_295: 9 16 0 0 self 230)
			)
			(1
				(openDrawer sel_110:)
				(sFX sel_40: 42 sel_39:)
				(= sel_136 1)
			)
			(2 (self sel_111:))
		)
	)
)

(instance openDrawer of View
	(properties
		sel_20 {openDrawer}
		sel_1 66
		sel_0 120
		sel_213 20
		sel_214 230
		sel_2 235
		sel_3 1
		sel_14 16385
	)
	
	(method (sel_110)
		(super sel_110:)
		(if (not (gEgo sel_238: 6)) (pressPass sel_110:))
		(if (proc0_2 29) (keyInDrawerC sel_111:))
		(keyInDrawerO sel_110:)
	)
	
	(method (sel_111)
		(super sel_111:)
		(pressPass sel_111:)
		(keyInDrawerO sel_111:)
		(if (proc0_2 29) (keyInDrawerC sel_110:))
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(4
				(sFX sel_40: 42 sel_39:)
				(openDrawer sel_111:)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance cornerUpLF of View
	(properties
		sel_20 {cornerUpLF}
		sel_1 69
		sel_0 100
		sel_213 19
		sel_214 230
		sel_2 235
		sel_60 8
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance cornerUpRF of View
	(properties
		sel_20 {cornerUpRF}
		sel_1 200
		sel_0 100
		sel_213 19
		sel_214 230
		sel_2 235
		sel_4 1
		sel_60 8
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance cornerUpRB of View
	(properties
		sel_20 {cornerUpRB}
		sel_1 174
		sel_0 83
		sel_213 19
		sel_214 230
		sel_2 235
		sel_4 2
		sel_60 8
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance cornerUpLB of View
	(properties
		sel_20 {cornerUpLB}
		sel_1 97
		sel_0 85
		sel_213 19
		sel_214 230
		sel_2 235
		sel_4 3
		sel_60 8
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance keyUnder of View
	(properties
		sel_20 {keyUnder}
		sel_1 216
		sel_0 118
		sel_213 21
		sel_214 230
		sel_2 235
		sel_3 3
		sel_60 9
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(gEgo sel_350: 5)
				((ScriptID 21 0) sel_57: 774)
				(keyUnder sel_111:)
			)
			(1 (global2 sel_422: inKey))
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance keyInDrawerO of View
	(properties
		sel_20 {keyInDrawerO}
		sel_1 154
		sel_0 155
		sel_213 22
		sel_214 230
		sel_2 235
		sel_3 2
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance keyInDrawerC of View
	(properties
		sel_20 {keyInDrawerC}
		sel_1 154
		sel_0 132
		sel_213 23
		sel_214 230
		sel_2 235
		sel_3 2
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance pressPass of View
	(properties
		sel_20 {pressPass}
		sel_1 92
		sel_0 137
		sel_213 27
		sel_214 15
		sel_2 235
		sel_3 4
		sel_4 1
		sel_60 14
		sel_14 16401
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				((ScriptID 22 0) sel_57: 1)
				(gGame sel_87: 1 128)
				(gEgo sel_350: 6)
				((ScriptID 21 0) sel_57: 775)
				(pressPass sel_111:)
			)
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(1
				(global2 sel_422: inPressPass)
				(gLb2Messager sel_295: 27 1 0 0 0 15)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inPressPass of Inset
	(properties
		sel_20 {inPressPass}
		sel_2 235
		sel_3 4
		sel_1 85
		sel_0 129
		sel_570 1
		sel_214 15
		sel_213 27
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				((ScriptID 22 0) sel_57: 1)
				(gGame sel_87: 1 128)
				(gEgo sel_350: 6)
				((ScriptID 21 0) sel_57: 775)
				(pressPass sel_111:)
				(inPressPass sel_111:)
			)
			(1
				(gLb2Messager sel_295: 27 1 0 0 0 15)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inKey of Inset
	(properties
		sel_20 {inKey}
		sel_2 235
		sel_3 3
		sel_4 1
		sel_1 187
		sel_0 92
		sel_560 1
		sel_570 1
		sel_214 15
		sel_213 9
	)
	
	(method (sel_110)
		(super sel_110: &rest)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 9 1 0 0 0 15)
			)
			(4
				(gEgo sel_350: 5)
				((ScriptID 21 0) sel_57: 774)
				(inKey sel_111:)
				(keyUnder sel_111:)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterRF of Feature
	(properties
		sel_20 {closeupBlotterRF}
		sel_0 109
		sel_213 10
		sel_214 230
		sel_301 40
		sel_302 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sLiftMat 0 2)
			)
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterRB of Feature
	(properties
		sel_20 {closeupBlotterRB}
		sel_0 95
		sel_213 10
		sel_214 230
		sel_301 40
		sel_302 8192
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sLiftMat 0 3)
			)
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterLB of Feature
	(properties
		sel_20 {closeupBlotterLB}
		sel_0 95
		sel_213 10
		sel_214 230
		sel_301 40
		sel_302 4096
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sLiftMat 0 1)
			)
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance closeupBlotterLF of Feature
	(properties
		sel_20 {closeupBlotterLF}
		sel_0 109
		sel_213 10
		sel_214 230
		sel_301 40
		sel_302 2048
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sLiftMat 0 0)
			)
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance restOfBlotter of Feature
	(properties
		sel_20 {restOfBlotter}
		sel_0 109
		sel_213 26
		sel_214 230
		sel_302 1024
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance pencilHolder of Feature
	(properties
		sel_20 {pencilHolder}
		sel_1 227
		sel_0 78
		sel_213 8
		sel_214 230
		sel_6 64
		sel_7 219
		sel_8 92
		sel_9 236
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance drawer of Feature
	(properties
		sel_20 {drawer}
		sel_1 155
		sel_0 137
		sel_213 9
		sel_214 230
		sel_6 128
		sel_7 67
		sel_8 146
		sel_9 244
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					((gSel_561 sel_122: openDrawer) (sFX sel_40: 42 sel_39:) (openDrawer sel_111:))
					((proc0_2 29) (sFX sel_40: 42 sel_39:) (openDrawer sel_110:))
					(local0 (gLb2Messager sel_295: 9 4 3 0 0 230))
					((not (gEgo sel_238: 6)) (sFX sel_40: 42 sel_39:) (openDrawer sel_110:))
					(else (gLb2Messager sel_295: 9 4 4 0 0 230))
				)
			)
			(16
				(global2 sel_146: sUseKeyOnDrawer)
			)
			(13
				(proc0_8 0)
				(global2 sel_399: 230)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 5
		sel_40 42
	)
)
