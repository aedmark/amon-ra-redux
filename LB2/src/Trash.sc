;;; Sierra Script 1.0 - (do not remove this comment)
(script# 250)
(include sci.sh)
(use Main)
(use LBRoom)
(use n027)
(use Print)
(use Inset)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use View)
(use Obj)

(public
	rm250 0
)

(local
	local0
	theTrash
	local2
)
(instance rm250 of LBRoom
	(properties
		sel_20 {rm250}
		sel_213 14
		sel_408 250
	)
	
	(method (sel_110 &tmp [temp0 50])
		(proc958_0 128 250 251 252 253 254)
		(proc958_0 132 300 41 250 252)
		(noise sel_40: 41 sel_99: 5 sel_39:)
		(super sel_110:)
		(proc0_8 1)
		(gLb2WH sel_129: global2)
		(User sel_347: 1)
		(laura sel_4: (if (gEgo sel_584?) 1 else 0) sel_317:)
		(license sel_110:)
		(if (proc0_10 16 1)
			(trash1 sel_110:)
			(trash2 sel_110:)
			(trash3 sel_110:)
			(trash4 sel_110:)
			(trash5 sel_110:)
			(cornerTrash sel_317:)
			(if
				(and
					(not (gEgo sel_584?))
					(not (gEgo sel_238: 1))
					(not (gEgo sel_238: 32))
				)
				(ticket sel_110:)
			)
			(DDriver sel_317:)
		else
			(CDriver sel_317:)
		)
		(gSel_608 sel_40: 250)
		(win1 sel_110: sel_313:)
		(win2 sel_110: sel_313:)
		(win3 sel_110: sel_313:)
		(win4 sel_110: sel_313:)
		(win5 sel_110: sel_313:)
		(gNarrator sel_0: 120)
		(cond 
			((and (== gGSel_40 300) (gEgo sel_584?)) (self sel_146: sACTBREAK))
			((not (gEgo sel_238: 6))
				(if (gSel_561 sel_122: trash1)
					(self sel_146: sNoPressPassD)
				else
					(self sel_146: sNoPressPassC)
				)
			)
			(else (self sel_146: sHasPressPass))
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
	
	(method (sel_399)
		(if sel_365 (sel_365 sel_111:))
		(gLb2WH sel_81: global2)
		(if (gLb2Messager sel_290?) (gLb2Messager sel_111:))
		(proc0_8 0)
		(super sel_399: &rest)
	)
)

(instance sACTBREAK of Script
	(properties
		sel_20 {sACTBREAK}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gIconBar sel_233:)
				(proc27_2)
				((ScriptID 21 1) sel_57: 1029)
				(win1 sel_161: Fwd)
				(win2 sel_161: Fwd)
				(win3 sel_161: Fwd)
				(win4 sel_161: Fwd)
				(win5 sel_161: Fwd)
				(gGameMusic2 sel_173: 2 224 2400)
				(= sel_136 1)
			)
			(1
				(gGameMusic2 sel_173: 2 224 2800)
				(= sel_136 1)
			)
			(2
				(gGameMusic2 sel_173: 2 224 3200)
				(= sel_136 1)
			)
			(3
				(gGameMusic2 sel_173: 2 224 3600)
				(= sel_136 1)
			)
			(4
				(gGameMusic2 sel_173: 2 224 4000)
				(gSel_608 sel_40: 300 sel_3: 1 sel_99: 1 sel_39: self)
			)
			(5
				(gGameMusic2 sel_173: 2 224 3000)
				(= sel_136 1)
			)
			(6
				(gGameMusic2 sel_173: 2 224 2000)
				(= sel_136 1)
			)
			(7
				(gGameMusic2 sel_173: 2 224 1000)
				(= sel_136 1)
			)
			(8
				(gGameMusic2 sel_173: 2 224 500)
				(= sel_136 1)
			)
			(9
				(gGameMusic2 sel_173: 2 224 0)
				(= sel_136 5)
			)
			(10
				(gSel_608 sel_170:)
				(gGameMusic2 sel_170:)
				(global2 sel_399: 26)
			)
		)
	)
)

(instance sNoPressPassD of Script
	(properties
		sel_20 {sNoPressPassD}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(User sel_347: 1)
				(= sel_136 1)
			)
			(1
				(gLb2Messager sel_295: 1 0 9 1 self)
			)
			(2
				(gLb2Messager sel_295: 1 0 10 1 self)
			)
			(3
				(gLb2Messager sel_295: 1 0 9 2 self)
			)
			(4
				(gGame sel_588:)
				(= sel_137 15)
			)
			(5
				(gLb2Messager sel_295: 1 0 9 3 self)
			)
			(6
				(global2 sel_399: (if gGSel_40 else 210))
			)
		)
	)
)

(instance sNoPressPassC of Script
	(properties
		sel_20 {sNoPressPassC}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(User sel_347: 1)
				(= sel_136 1)
			)
			(1
				(gLb2Messager sel_295: 1 0 1 1 self)
			)
			(2
				(gLb2Messager sel_295: 1 0 10 1 self)
			)
			(3
				(gLb2Messager sel_295: 1 0 1 2 self)
			)
			(4
				(gGame sel_588:)
				(= sel_137 15)
			)
			(5
				(gLb2Messager sel_295: 1 0 1 3 self)
			)
			(6
				(global2 sel_399: (if gGSel_40 else 210))
			)
		)
	)
)

(instance sHasPressPass of Script
	(properties
		sel_20 {sHasPressPass}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(User sel_347: 1)
				(= sel_136 1)
			)
			(1
				(cond 
					(
					(and (gSel_561 sel_122: trash1) (not (proc0_2 26))) (sel_42 sel_146: s1stTimeInDirtyTaxi self))
					((gSel_561 sel_122: trash1) (gLb2Messager sel_295: 1 0 7 6 self))
					((not (gSel_561 sel_122: trash1)) (gLb2Messager sel_295: 1 0 8 0 self))
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

(instance s1stTimeInDirtyTaxi of Script
	(properties
		sel_20 {s1stTimeInDirtyTaxi}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(User sel_347: 1)
				(= sel_136 1)
			)
			(1
				(gLb2Messager sel_295: 1 0 7 1 self)
			)
			(2
				(gLb2Messager sel_295: 1 0 7 2 self)
				(proc0_3 26)
			)
			(3
				(= sel_141 0)
				(switch
					(Print
						sel_198: 16 0 0 0
						sel_205: 1 15 0 0 1 5 18
						sel_205: 2 15 0 0 2 5 48
						sel_110:
					)
					(1
						(gLb2Messager sel_295: 1 0 7 6 self)
					)
					(2
						(gLb2Messager sel_295: 1 0 7 5 self)
						(= sel_141 1)
					)
					(else  (= sel_136 1))
				)
			)
			(4 (= sel_137 1))
			(5
				(if (== sel_141 1)
					(global2 sel_399: (if gGSel_40 else 210))
				else
					(= sel_136 1)
				)
			)
			(6
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sWhereToBud of Script
	(properties
		sel_20 {sWhereToBud}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(User sel_347: 1)
				(= sel_136 1)
			)
			(1
				(if (not (gSel_561 sel_122: trash1))
					(gLb2Messager sel_295: 5 11 8 0 self)
				else
					(gLb2Messager sel_295: 4 11 7 0 self)
				)
			)
			(2
				(switch (global2 sel_422: (ScriptID 20 0))
					(513 (= local0 210))
					(515 (= local0 260))
					(516 (= local0 240))
					(514 (= local0 280))
					(518 (= local0 300))
					(520 (= local0 300))
					(517 (= local0 330))
					(519
						(= local2 1)
						(= local0 250)
						(if (not (gSel_561 sel_122: trash1))
							(gLb2Messager sel_295: 17 14 8 0)
						else
							(gLb2Messager sel_295: 17 14 7 0)
						)
					)
					(-1 (= local0 250))
					(else 
						(= local0 250)
						(if (not (gSel_561 sel_122: trash1))
							(gLb2Messager sel_295: 12 14 8 0)
						else
							(gLb2Messager sel_295: 12 14 7 0)
						)
					)
				)
				(= sel_136 1)
			)
			(3
				(cond 
					((or (== local0 gGSel_40) (== local0 gSel_40)) (gGame sel_588:) (= sel_136 1))
					((not (gSel_561 sel_122: trash1)) (self sel_146: sDoTakeOffFlight self))
					(else (self sel_146: sMoveBuildings self))
				)
			)
			(4
				(gIconBar sel_177: 5)
				(if (!= local0 gSel_40)
					(global2 sel_399: local0)
				else
					(self sel_111:)
				)
			)
		)
	)
)

(instance sDoTakeOffFlight of Script
	(properties
		sel_20 {sDoTakeOffFlight}
	)
	
	(method (sel_57)
		(if
			(and
				(== (self sel_29?) 9)
				(== (gSel_608 sel_40?) 250)
				(== (gSel_608 sel_165?) -1)
			)
			(self sel_145:)
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29 &tmp [temp0 50])
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(User sel_347: 1)
				(= sel_136 1)
			)
			(1
				(win1 sel_161: Fwd)
				(win2 sel_161: Fwd)
				(win3 sel_161: Fwd)
				(win4 sel_161: Fwd)
				(win5 sel_161: Fwd)
				(= sel_136 1)
			)
			(2
				(gSel_608 sel_40: 250 sel_3: 1 sel_99: 1 sel_39:)
				(gGame sel_588:)
				(gIconBar sel_233: 5 6 0)
				(= sel_136 1)
			)
			(3
				(gGameMusic2 sel_173: 2 224 1000)
				(= sel_136 1)
			)
			(4
				(gGameMusic2 sel_173: 2 224 2000)
				(= sel_136 1)
			)
			(5
				(gGameMusic2 sel_173: 2 224 3000)
				(= sel_136 1)
			)
			(6
				(gGameMusic2 sel_173: 2 224 4000)
				((ScriptID 1902 13) sel_203: 1)
				((ScriptID 1903 14) sel_203: 1)
				(= sel_141 (Random 11 17))
				(cond 
					((== sel_141 17) (= sel_137 8))
					((== sel_141 16) (= sel_137 8))
					(else (gLb2Messager sel_295: 10 0 sel_141 0 self))
				)
			)
			(7
				(gGameMusic2 sel_173: 2 224 3000)
				(= sel_136 1)
			)
			(8
				(gGameMusic2 sel_173: 2 224 2000)
				(= sel_136 1)
			)
			(9 0)
			(10
				(win1 sel_161: 0)
				(win2 sel_161: 0)
				(win3 sel_161: 0)
				(win4 sel_161: 0)
				(win5 sel_161: 0)
				(gGameMusic2 sel_173: 2 224 1000)
				(if (== sel_141 16)
					(gLb2Messager sel_295: 10 0 16 0 self)
				else
					(= sel_141 0)
					(= sel_136 1)
				)
			)
			(11
				(gGameMusic2 sel_173: 2 224 500)
				(= sel_136 1)
			)
			(12
				(gGameMusic2 sel_173: 2 224 0)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sMoveBuildings of Script
	(properties
		sel_20 {sMoveBuildings}
	)
	
	(method (sel_57)
		(if
			(and
				(== (self sel_29?) 6)
				(== (gSel_608 sel_40?) 250)
				(== (gSel_608 sel_165?) -1)
			)
			(self sel_145:)
		)
		(super sel_57:)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(win1 sel_161: Fwd)
				(win2 sel_161: Fwd)
				(win3 sel_161: Fwd)
				(win4 sel_161: Fwd)
				(win5 sel_161: Fwd)
				(= sel_136 1)
			)
			(1
				(gSel_608 sel_40: 250 sel_3: 1 sel_99: 1 sel_39:)
				(gGame sel_588:)
				(gIconBar sel_233: 5 6 0)
				(= sel_136 1)
			)
			(2
				(gGameMusic2 sel_173: 2 224 1000)
				(= sel_136 1)
			)
			(3
				(gGameMusic2 sel_173: 2 224 2000)
				(= sel_136 1)
			)
			(4
				(gGameMusic2 sel_173: 2 224 3000)
				(= sel_136 1)
			)
			(5
				(gGameMusic2 sel_173: 2 224 4000)
				(= sel_137 (Random 6 10))
			)
			(6 0)
			(7
				(self sel_111:)
				(gSel_608 sel_170:)
			)
		)
	)
)

(instance laura of View
	(properties
		sel_20 {laura}
		sel_0 100
		sel_82 75
		sel_2 251
		sel_60 10
		sel_14 4113
	)
	
	(method (sel_300 param1)
		(if (== param1 13)
			(global2 sel_399: (if gGSel_40 else 210))
		else
			(gEgo sel_300: param1 &rest)
		)
	)
)

(instance DDriver of View
	(properties
		sel_20 {DDriver}
		sel_1 232
		sel_0 104
		sel_213 4
		sel_2 252
		sel_3 1
		sel_60 4
		sel_14 6161
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(1
				(gLb2Messager sel_295: 4 1 7 0)
			)
			(4
				(gLb2Messager sel_295: 4 4 7 0)
			)
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(6
				(cond 
					(local2 (global2 sel_146: sWhereToBud))
					(
						(and
							(<= 512 (= temp0 (global2 sel_422: (ScriptID 20 0))))
							(<= temp0 665)
						)
						(gLb2Messager sel_295: 11 6 7 0)
					)
					(else (gLb2Messager sel_295: 12 6 7 0))
				)
			)
			(2
				(gLb2Messager sel_295: 4 2 7 0)
			)
			(11
				(global2 sel_146: sWhereToBud)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance CDriver of View
	(properties
		sel_20 {CDriver}
		sel_1 232
		sel_0 104
		sel_213 5
		sel_2 252
		sel_60 4
		sel_14 6161
	)
	
	(method (sel_300 param1 &tmp temp0)
		(switch param1
			(1
				(gLb2Messager sel_295: 5 1 8 0)
			)
			(4
				(gLb2Messager sel_295: 5 4 8 0)
			)
			(6
				(cond 
					(local2 (global2 sel_146: sWhereToBud))
					(
						(and
							(<= 512 (= temp0 (global2 sel_422: (ScriptID 20 0))))
							(<= temp0 665)
						)
						(gLb2Messager sel_295: 11 6 8 0)
					)
					(else (gLb2Messager sel_295: 12 6 8 0))
				)
			)
			(2
				(gLb2Messager sel_295: 5 2 8 0)
			)
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(11
				(global2 sel_146: sWhereToBud)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance win1 of Prop
	(properties
		sel_20 {win1}
		sel_1 87
		sel_0 96
		sel_213 6
		sel_2 253
		sel_60 2
		sel_14 17
		sel_244 7
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance win2 of Prop
	(properties
		sel_20 {win2}
		sel_1 141
		sel_0 97
		sel_213 6
		sel_2 253
		sel_3 1
		sel_60 2
		sel_14 16401
		sel_244 7
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance win3 of Prop
	(properties
		sel_20 {win3}
		sel_1 159
		sel_0 92
		sel_213 6
		sel_2 254
		sel_60 2
		sel_14 17
		sel_244 7
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance win4 of Prop
	(properties
		sel_20 {win4}
		sel_1 213
		sel_0 88
		sel_213 6
		sel_2 254
		sel_3 1
		sel_60 2
		sel_14 17
		sel_244 7
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance win5 of Prop
	(properties
		sel_20 {win5}
		sel_1 268
		sel_0 89
		sel_213 6
		sel_2 254
		sel_3 2
		sel_60 2
		sel_14 17
		sel_244 7
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance inTicket of Inset
	(properties
		sel_20 {inTicket}
		sel_2 250
		sel_1 190
		sel_0 154
		sel_570 1
		sel_213 9
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				((ScriptID 21 0) sel_57: 770)
				(ticket sel_111:)
				(inTicket sel_111:)
				(gEgo sel_350: -1 1)
				(proc0_3 27)
			)
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance ticket of View
	(properties
		sel_20 {ticket}
		sel_1 149
		sel_0 178
		sel_2 250
		sel_3 2
		sel_60 8
		sel_14 16
	)
	
	(method (sel_300 param1 param2)
		(switch param1
			(1 (global2 sel_422: inTicket))
			(4
				(gEgo sel_350: 1)
				(proc0_3 27)
				((ScriptID 21 0) sel_57: 770)
				(self sel_111:)
			)
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 param2 &rest)
			)
		)
	)
)

(instance license of Feature
	(properties
		sel_20 {license}
		sel_1 246
		sel_0 114
		sel_6 99
		sel_7 219
		sel_8 130
		sel_9 274
		sel_301 40
	)
	
	(method (sel_300 param1)
		(if (gSel_561 sel_122: trash1)
			(= sel_213 7)
		else
			(= sel_213 8)
		)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(class Trash of View
	(properties
		sel_20 {Trash}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 2
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_52 2
		sel_2 250
		sel_3 1
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 257
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_16 0
		sel_17 0
		sel_18 0
		sel_19 0
		sel_88 0
		sel_103 0
		sel_104 128
		sel_105 128
		sel_106 128
		sel_671 0
		sel_672 319
		sel_673 155
		sel_674 189
	)
	
	(method (sel_110)
		(if (proc0_10 16 1)
			(gLb2MDH sel_129: self)
			(gLb2KDH sel_129: self)
		)
		(super sel_110: &rest)
	)
	
	(method (sel_57)
		(if (and (== theTrash self) (self sel_675:))
			(= sel_1 gSel_1)
			(= sel_0 gSel_0)
		)
		(super sel_57: &rest)
	)
	
	(method (sel_111)
		(gLb2MDH sel_81: self)
		(gLb2KDH sel_81: self)
		(super sel_111:)
	)
	
	(method (sel_133 param1)
		(cond 
			(
				(and
					(== (param1 sel_37?) 13)
					(== (param1 sel_31?) 4)
					(== (gIconBar sel_207?) (gIconBar sel_64: 2))
					(self sel_218: param1)
				)
				(if (!= theTrash self)
					(= theTrash self)
					(noise sel_40: 54 sel_3: 1 sel_99: 5 sel_39:)
				else
					(= theTrash 0)
				)
				(param1 sel_73: 1)
			)
			(
				(and
					(== (param1 sel_31?) 1)
					(== (gIconBar sel_207?) (gIconBar sel_64: 2))
					(self sel_218: param1)
				)
				(noise sel_40: 54 sel_3: 1 sel_99: 5 sel_39:)
				(= theTrash self)
				(param1 sel_73: 1)
			)
			(
			(and (== (param1 sel_31?) 2) (self sel_218: param1)) (= theTrash 0) (param1 sel_73: 1))
			(else (super sel_133: param1 &rest))
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(global2 sel_399: (if gGSel_40 else 210))
			)
			(1
				(gLb2Messager sel_295: 3 1 4)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
	
	(method (sel_675)
		(if
			(and
				(> gSel_1 sel_671)
				(< gSel_1 sel_672)
				(> gSel_0 sel_673)
				(< gSel_0 sel_674)
			)
		)
	)
)

(instance trash1 of Trash
	(properties
		sel_20 {trash1}
		sel_1 166
		sel_0 176
		sel_4 2
		sel_14 16384
	)
)

(instance trash2 of Trash
	(properties
		sel_20 {trash2}
		sel_1 145
		sel_0 163
		sel_4 3
		sel_14 16384
	)
)

(instance trash3 of Trash
	(properties
		sel_20 {trash3}
		sel_1 148
		sel_0 181
		sel_4 4
		sel_14 16384
	)
)

(instance trash4 of Trash
	(properties
		sel_20 {trash4}
		sel_1 112
		sel_0 174
		sel_4 5
		sel_14 16384
	)
)

(instance trash5 of Trash
	(properties
		sel_20 {trash5}
		sel_1 58
		sel_0 174
		sel_14 16384
	)
)

(instance cornerTrash of View
	(properties
		sel_20 {cornerTrash}
		sel_1 261
		sel_0 189
		sel_213 2
		sel_2 250
		sel_3 3
		sel_60 1
		sel_14 2064
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(cond 
					((proc0_2 27) (gLb2Messager sel_295: 2 4 4))
					((proc0_10 16 1) (gLb2Messager sel_295: 2 4 2))
					((gEgo sel_584?) (gLb2Messager sel_295: 2 4 4))
					((gEgo sel_238: 0) (gLb2Messager sel_295: 2 4 4))
					(else (gLb2Messager sel_295: 2 4 4))
				)
			)
			(1
				(gLb2Messager sel_295: 3 1 4)
			)
			(else 
				(super sel_300: param1 &rest)
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
