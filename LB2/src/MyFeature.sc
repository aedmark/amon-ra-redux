;;; Sierra Script 1.0 - (do not remove this comment)
(script# 650)
(include sci.sh)
(use Main)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
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
	rm650 0
)

(local
	local0
	local1
	local2
)
(instance rm650 of LBRoom
	(properties
		sel_20 {rm650}
		sel_213 41
		sel_408 650
		sel_409 666
		sel_411 600
		sel_108 -30
	)
	
	(method (sel_110)
		(proc958_0 128 652 654)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 140 0 190 -30)
		(self sel_414: 90)
		(switch gGSel_40
			(sel_411 (gEgo sel_1: 160))
			(else 
				(gEgo sel_584: 1 sel_153: 180 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(proc958_0 132 651 652 655 49 721)
		(gGameMusic2 sel_40: 650 sel_99: 1 sel_3: -1 sel_39:)
		(chair sel_110:)
		(shelf sel_110:)
		(mace sel_110:)
		(maceChain sel_110:)
		(leftWeapon sel_110:)
		(medalsA sel_110:)
		(medalsB sel_110:)
		(desk sel_110:)
		(light sel_110:)
		(chairWolf sel_110:)
		(lamp sel_110:)
		(blotter sel_110:)
		(intercom sel_110:)
		(shelf1 sel_110: sel_311: 1 4)
		(shelf2 sel_110: sel_311: 1 4)
		(shelf3 sel_110: sel_311: 1 4)
		(shelf4 sel_110: sel_311: 1 4)
		(shelf5 sel_110: sel_311: 1 4)
		(shelf6a sel_110: sel_311: 1 4)
		(shelf6b sel_110: sel_311: 1 4)
		(shelf6c sel_110: sel_311: 1 4)
		(shelf6d sel_110: sel_311: 1 4)
		(shelf7 sel_110: sel_311: 1 4)
		(shelf8 sel_110: sel_311: 1 4)
		(weapons1 sel_110:)
		(weapons2 sel_110:)
		(weapons3 sel_110:)
		(weapons4 sel_110:)
		(weaponsB sel_110:)
		(secretShelf sel_110:)
		(if (proc0_2 117)
			(secretPanel
				sel_311: 4
				sel_156: (secretPanel sel_246:)
				sel_110:
			)
		else
			(secretPanel sel_110: sel_311: 4)
		)
		(trap sel_317:)
		(sword sel_110:)
		(string1 sel_110: sel_311: 22 21)
		(string2 sel_110: sel_311: 22 21)
		(string3 sel_110: sel_311: 22 21)
		(if (proc0_2 11)
			(gun sel_110:)
			(gunFire sel_156: (gunFire sel_246:) sel_110:)
			(string1 sel_156: (string1 sel_246:))
			(string2 sel_156: (string2 sel_246:))
			(string3 sel_156: (string3 sel_246:))
		else
			(proc958_0 132 653 654)
		)
		(southExit sel_110:)
		(eastExit sel_110:)
		(cond 
			(
				(and
					(== global123 3)
					(not (proc0_2 57))
					(not (proc0_10 8224))
				)
				(if (== ((ScriptID 90 2) sel_620?) gSel_40)
					((ScriptID 90 2) sel_618: 520)
				)
				(string1 sel_146: sIntercom)
			)
			(
				(and
					(== ((ScriptID 90 2) sel_620?) gSel_40)
					(not (gEgo sel_238: 17))
				)
				((ScriptID 90 2) sel_618: 520)
			)
		)
	)
	
	(method (sel_57)
		(super sel_57:)
		(cond 
			(sel_142)
			((proc0_1 gEgo 2) (self sel_146: sExitToSouth))
		)
	)
	
	(method (sel_111)
		(gGameMusic2 sel_170:)
		(super sel_111:)
	)
	
	(method (sel_399)
		(super sel_399: &rest)
		(if (== gTheGSel_40 sel_409) (proc0_4 117))
	)
)

(instance sExitToSouth of Script
	(properties
		sel_20 {sExitToSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: MoveTo 330 (gEgo sel_0?) self)
			)
			(1
				(global2 sel_399: (global2 sel_411?))
			)
		)
	)
)

(instance sIntercom of Script
	(properties
		sel_20 {sIntercom}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_136 2))
			(1 (= sel_137 30))
			(2
				(if (global2 sel_142?)
					(-- sel_29)
					(= sel_137 5)
				else
					(gLb2Messager sel_295: 40)
					(= sel_136 1)
				)
			)
			(3
				(proc0_3 57)
				(self sel_111:)
			)
		)
	)
)

(instance sTouchTrap of Script
	(properties
		sel_20 {sTouchTrap}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 179 157 self)
			)
			(1
				(gEgo
					sel_2: 652
					sel_155: 2
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(2
				(gGameMusic2 sel_167:)
				(sFX sel_40: 654 sel_99: 5 sel_3: 1 sel_39:)
				(string1 sel_161: End self)
			)
			(3
				(string1 sel_313:)
				(string2 sel_161: End self)
			)
			(4
				(string2 sel_313:)
				(string3 sel_161: End self)
			)
			(5
				(string3 sel_313:)
				(gun sel_110:)
				(= sel_139 60)
			)
			(6
				(gun sel_161: Fwd)
				(sFX sel_40: 653 sel_99: 1 sel_3: -1 sel_39:)
				(gunFire sel_110: sel_244: 10 sel_161: End)
				(gEgo
					sel_155: 3
					sel_156: 0
					sel_312: MoveTo (+ (gEgo sel_1?) 7) (+ (gEgo sel_0?) 3)
					sel_161: End self
				)
			)
			(7 (= sel_139 60))
			(8
				(sFX sel_167:)
				(gun sel_161: 0 sel_156: 0)
				(= sel_139 120)
			)
			(9
				(= global145 6)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sDisarmTrap of Script
	(properties
		sel_20 {sDisarmTrap}
	)
	
	(method (sel_144 theSel_29 &tmp temp0 temp1)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(if (== sel_141 30)
					(= temp0 206)
					(= temp1 152)
				else
					(= temp0 203)
					(= temp1 150)
				)
				(gEgo sel_312: PolyPath temp0 temp1 self)
			)
			(1 (gEgo sel_253: 270 self))
			(2
				(gEgo
					sel_2: 652
					sel_155: (if (== sel_141 30) 0 else 1)
					sel_156: 0
					sel_63: 13
					sel_244: 12
					sel_161: End self
				)
			)
			(3
				(sFX sel_40: 654 sel_99: 5 sel_3: 1 sel_39:)
				(gEgo sel_585: 831 sel_3: 1)
				(string1 sel_161: End self)
			)
			(4
				(string1 sel_313:)
				(string2 sel_161: End self)
			)
			(5
				(string2 sel_313:)
				(string3 sel_161: End self)
			)
			(6
				(string3 sel_313:)
				(gun sel_110:)
				(= sel_139 60)
			)
			(7
				(gun sel_161: Fwd)
				(sFX sel_40: 653 sel_99: 1 sel_3: -1 sel_39:)
				(gunFire sel_110: sel_244: 10 sel_161: End)
				(= sel_139 180)
			)
			(8
				(sFX sel_167:)
				(gun sel_161: 0 sel_156: 0)
				(proc0_3 11)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sGetCheese of Script
	(properties
		sel_20 {sGetCheese}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 179 157 self)
			)
			(1
				(gEgo
					sel_2: 652
					sel_155: 2
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(2
				(gEgo sel_350: 16)
				((ScriptID 21 0) sel_57: 785)
				(gGame sel_87: 1 152)
				(= sel_136 1)
			)
			(3
				(gEgo sel_2: 652 sel_155: 2 sel_156: 0 sel_161: Beg self)
			)
			(4
				(gEgo sel_585: 831 sel_3: 1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sLookTrap of Script
	(properties
		sel_20 {sLookTrap}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(if (< (gEgo sel_1?) 169)
					(gEgo sel_312: PolyPath 153 163 self)
				else
					(gEgo sel_312: PolyPath 186 154 self)
				)
			)
			(1 (proc0_5 gEgo trap self))
			(2
				(global2 sel_422: inCheese)
				(self sel_111:)
			)
		)
	)
)

(instance sSwordKill of Script
	(properties
		sel_20 {sSwordKill}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 282 130 self)
			)
			(1
				(gEgo
					sel_2: 652
					sel_155: 4
					sel_156: 0
					sel_244: 10
					sel_161: End self
				)
			)
			(2
				(gGameMusic2 sel_167:)
				(sFX sel_40: 655 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo sel_155: 5 sel_156: 0 sel_161: CT 5 1 self)
				(sword sel_111:)
			)
			(3
				(sFX sel_40: 652 sel_99: 1 sel_3: 1 sel_39:)
				(gEgo sel_161: End self)
			)
			(4 (= sel_139 150))
			(5
				(= global145 13)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sShocked of Script
	(properties
		sel_20 {sShocked}
	)
	
	(method (sel_144 theSel_29 &tmp temp0 temp1)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(switch sel_141
					(0 (= temp0 200) (= temp1 109))
					(1 (= temp0 212) (= temp1 112))
					(2 (= temp0 227) (= temp1 122))
					(3 (= temp0 250) (= temp1 123))
					(4 (= temp0 298) (= temp1 134))
				)
				(gEgo sel_312: PolyPath temp0 temp1 self)
			)
			(1
				(gEgo
					sel_2: 654
					sel_155: 0
					sel_156: 0
					sel_244: 4
					sel_161: CT 4 1 self
				)
			)
			(2
				(sFX sel_40: 651 sel_99: 1 sel_3: -1 sel_39:)
				(gEgo sel_161: Osc 1 self)
			)
			(3
				(sFX sel_167:)
				(= sel_139 30)
			)
			(4
				(gEgo sel_155: 1 sel_156: 0 sel_244: 10 sel_161: End self)
			)
			(5 (= sel_139 150))
			(6 (gEgo sel_161: Beg self))
			(7
				(gEgo sel_585: 831 sel_3: 0)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sShockedWire of Script
	(properties
		sel_20 {sShockedWire}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 652
					sel_155: 2
					sel_156: 0
					sel_244: 12
					sel_161: End self
				)
			)
			(1
				(gEgo
					sel_2: 654
					sel_155: 0
					sel_156: 4
					sel_244: 4
					sel_161: End self
				)
				(sFX sel_40: 651 sel_99: 1 sel_3: -1 sel_39:)
			)
			(2 (gEgo sel_161: CT 4 -1 self))
			(3
				(sFX sel_167:)
				(gEgo
					sel_2: 652
					sel_155: 2
					sel_156: (gEgo sel_246:)
					sel_244: 12
				)
				(= sel_139 15)
			)
			(4
				(gLb2Messager sel_295: 35 21 0 0 self)
			)
			(5 (gEgo sel_161: Beg self))
			(6
				(gEgo sel_585: 831 sel_3: 1)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sShockedWire3 of Script
	(properties
		sel_20 {sShockedWire3}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_2: 654
					sel_155: 0
					sel_156: 0
					sel_244: 4
					sel_161: Osc 1 self
				)
				(sFX sel_40: 651 sel_99: 1 sel_3: -1 sel_39:)
			)
			(1
				(sFX sel_167:)
				(= sel_139 30)
			)
			(2
				(gEgo sel_155: 1 sel_156: 0 sel_244: 10 sel_161: End self)
			)
			(3
				(gLb2Messager sel_295: 35 21 0 0 self)
			)
			(4 (gEgo sel_161: Beg self))
			(5
				(gEgo sel_585: 831 sel_3: 0)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sEnterSecretPassage of Script
	(properties
		sel_20 {sEnterSecretPassage}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo
					sel_2: 652
					sel_155: 4
					sel_156: 0
					sel_161: CT 3 1 self
				)
			)
			(1
				(sFX sel_40: 49 sel_99: 5 sel_3: 1 sel_39: self)
			)
			(2
				(gEgo sel_585: 831 sel_3: 0)
				(secretShelf
					sel_155: 6
					sel_312: MoveTo 161 (secretShelf sel_0?) self
				)
				(sFX sel_40: 721 sel_99: 5 sel_3: -1 sel_39:)
			)
			(3
				(sFX sel_167:)
				(secretShelf sel_313:)
				(gEgo sel_312: PolyPath 132 107 self)
			)
			(4
				(gEgo sel_312: MoveTo 126 99 self)
			)
			(5
				(global2 sel_399: (global2 sel_409?))
				(self sel_111:)
			)
		)
	)
)

(instance sShortPause of Script
	(properties
		sel_20 {sShortPause}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_139 60))
			(1
				(gLb2Messager sel_295: 32 4)
				(self sel_111:)
			)
		)
	)
)

(instance secretShelf of Actor
	(properties
		sel_20 {secretShelf}
		sel_1 137
		sel_0 15
		sel_82 -89
		sel_2 650
		sel_3 6
		sel_14 16385
	)
)

(instance secretPanel of Prop
	(properties
		sel_20 {secretPanel}
		sel_1 199
		sel_0 80
		sel_303 196
		sel_304 118
		sel_2 650
		sel_3 7
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if sel_4
					(gLb2Messager sel_295: 43 1)
				else
					(gLb2Messager sel_295: 6 1)
				)
			)
			(4
				(sFX sel_40: 49 sel_99: 5 sel_3: 1 sel_39:)
				(if sel_4
					(secretButton sel_111:)
					(self sel_161: Beg self)
					(proc0_4 117)
				else
					(secretButton sel_110: sel_311: 4)
					(self sel_161: End self)
					(proc0_3 117)
				)
			)
			(else  (super sel_300: param1))
		)
	)
	
	(method (sel_145)
		(sFX sel_167:)
		(self sel_313:)
	)
)

(instance gun of Prop
	(properties
		sel_20 {gun}
		sel_1 46
		sel_0 91
		sel_82 50
		sel_213 28
		sel_2 651
		sel_14 1
	)
)

(instance string1 of Prop
	(properties
		sel_20 {string1}
		sel_1 149
		sel_0 144
		sel_213 35
		sel_303 161
		sel_304 150
		sel_2 650
		sel_3 4
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(22
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShockedWire)
					else
						(return 1)
					)
				)
				(21
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShockedWire)
					else
						(return 1)
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance string2 of Prop
	(properties
		sel_20 {string2}
		sel_1 81
		sel_0 111
		sel_213 35
		sel_303 92
		sel_304 114
		sel_2 650
		sel_3 3
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(22
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShockedWire)
					else
						(return 1)
					)
				)
				(21
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShockedWire)
					else
						(return 1)
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance string3 of Prop
	(properties
		sel_20 {string3}
		sel_1 60
		sel_0 57
		sel_213 35
		sel_303 55
		sel_304 114
		sel_2 650
		sel_3 3
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(22
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShockedWire3)
					else
						(return 1)
					)
				)
				(21
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShockedWire3)
					else
						(return 1)
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance gunFire of Prop
	(properties
		sel_20 {gunFire}
		sel_1 150
		sel_0 143
		sel_2 652
		sel_3 7
		sel_14 16384
	)
)

(instance trap of View
	(properties
		sel_20 {trap}
		sel_1 165
		sel_0 157
		sel_2 651
		sel_3 1
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(1
					(if (not (gEgo sel_238: 16))
						(global2 sel_146: sLookTrap)
					else
						(gLb2Messager sel_295: 27 1 2)
					)
				)
				(8 (self sel_300: 1))
				(4
					(cond 
						((gEgo sel_238: 16) (gLb2Messager sel_295: 27 4 2))
						((proc0_2 11)
							(if (MuseumRgn sel_646:)
								(global2 sel_146: sGetCheese)
							else
								(return 1)
							)
						)
						((MuseumRgn sel_646:) (global2 sel_146: sTouchTrap))
						(else (return 1))
					)
				)
				(29
					(cond 
						((proc0_2 11)
							(if (gEgo sel_238: 16)
								(gLb2Messager sel_295: 27 4 2)
							else
								(gLb2Messager sel_295: 27 4 7)
							)
						)
						((MuseumRgn sel_646:) (global2 sel_146: sDisarmTrap 0 29))
						(else (return 1))
					)
				)
				(30
					(cond 
						((proc0_2 11) (gLb2Messager sel_295: 27 4 7))
						((MuseumRgn sel_646:) (global2 sel_146: sDisarmTrap 0 30))
						(else (return 1))
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance sword of View
	(properties
		sel_20 {sword}
		sel_1 287
		sel_0 40
		sel_213 25
		sel_2 652
		sel_3 6
		sel_14 16385
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(global2 sel_146: sSwordKill)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance inCheese of Inset
	(properties
		sel_20 {inCheese}
		sel_2 650
		sel_3 2
		sel_1 147
		sel_0 135
		sel_570 1
		sel_213 33
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(1
					(gLb2Messager sel_295: 33 1 5)
				)
				(8
					(gLb2Messager sel_295: 5 8 0 0 0 15)
				)
				(4
					(cond 
						((proc0_2 11)
							(if (MuseumRgn sel_646:)
								(global2 sel_146: sGetCheese)
							else
								(return 1)
							)
						)
						((MuseumRgn sel_646:) (global2 sel_146: sTouchTrap))
						(else (return 1))
					)
					(self sel_111:)
				)
				(29
					(cond 
						((proc0_2 11) (gLb2Messager sel_295: 27 4 2))
						((MuseumRgn sel_646:) (global2 sel_146: sDisarmTrap 0 29))
						(else (return 1))
					)
					(self sel_111:)
				)
				(30
					(cond 
						((proc0_2 11) (gLb2Messager sel_295: 27 4 2))
						((MuseumRgn sel_646:) (global2 sel_146: sDisarmTrap 0 30))
						(else (return 1))
					)
					(self sel_111:)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance inBooks of Inset
	(properties
		sel_20 {inBooks}
		sel_2 650
		sel_3 1
		sel_570 1
		sel_213 29
	)
	
	(method (sel_110)
		(= sel_1 (- local0 24))
		(= sel_0 (- local1 20))
		(if (== local2 6) (= sel_3 0) else (= sel_3 1))
		(super sel_110: &rest)
		(if (== local2 6)
			(poetryBook
				sel_110:
				sel_7: (+ sel_1 4)
				sel_6: (+ sel_0 6)
				sel_8: (+ sel_0 32)
				sel_9: (+ sel_1 16)
			)
		)
		(if (== local2 7)
			(heimlichBook
				sel_110:
				sel_7: (+ sel_1 16)
				sel_6: (+ sel_0 6)
				sel_8: (+ sel_0 32)
				sel_9: (+ sel_1 28)
			)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: (+ 13 local2) 1)
			)
			(4 (gLb2Messager sel_295: 29 4))
			(else  (super sel_300: param1))
		)
	)
)

(instance inClosedBook of Inset
	(properties
		sel_20 {inClosedBook}
		sel_2 650
		sel_3 5
		sel_4 1
		sel_1 88
		sel_0 65
		sel_570 1
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (gLb2Messager sel_295: 32 1))
			(4
				(global2 sel_422: inOpenBook)
			)
			(8 (gLb2Messager sel_295: 32 8))
			(else  (super sel_300: param1))
		)
	)
)

(instance inOpenBook of Inset
	(properties
		sel_20 {inOpenBook}
		sel_2 650
		sel_3 5
		sel_1 90
		sel_0 67
		sel_570 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(global2 sel_146: sShortPause)
	)
	
	(method (sel_111 param1)
		(super sel_111:)
		(if (and argc param1)
			(gEgo sel_350: 17)
			((ScriptID 21 0) sel_57: 786)
			(gGame sel_87: 1 153)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1 (global2 sel_422: inGarter))
			(8 (global2 sel_422: inGarter))
			(4 (self sel_111: 1))
			(else  (super sel_300: param1))
		)
	)
)

(instance inGarter of Inset
	(properties
		sel_20 {inGarter}
		sel_2 650
		sel_3 2
		sel_4 1
		sel_1 92
		sel_0 69
		sel_570 1
	)
	
	(method (sel_111 param1)
		(super sel_111:)
		(if (and argc param1)
			(gEgo sel_350: 17)
			((ScriptID 21 0) sel_57: 786)
			(gGame sel_87: 1 153)
		)
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(gLb2Messager sel_295: 12 1 0 0 0 15)
			)
			(8
				(gLb2Messager sel_295: 12 8 0 0 0 15)
			)
			(4 (self sel_111: 1))
			(else  (super sel_300: param1))
		)
	)
)

(class MyFeature of Feature
	(properties
		sel_20 {MyFeature}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
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
	)
	
	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1?))
			(= temp1 (param1 sel_0?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(= local0 temp0)
		(= local1 temp1)
		(return
			(cond 
				((IsObject sel_302) (AvoidPath temp0 temp1 sel_302))
				(
					(or
						(not (if (or sel_7 sel_9 sel_6) else sel_8))
						(and
							(<= sel_7 temp0)
							(<= temp0 sel_9)
							(<= sel_6 temp1)
							(<= temp1 sel_8)
						)
					)
					(if (!= sel_302 26505)
						(& sel_302 (OnControl 4 temp0 temp1))
					else
						1
					)
				)
			)
		)
	)
)

(instance secretButton of Feature
	(properties
		sel_20 {secretButton}
		sel_1 193
		sel_0 81
		sel_82 10
		sel_213 44
		sel_6 66
		sel_7 189
		sel_8 77
		sel_9 198
		sel_303 188
		sel_304 110
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(if (MuseumRgn sel_646:)
						(gGame sel_587:)
						(global2 sel_146: sEnterSecretPassage)
					else
						(return 1)
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance poetryBook of Feature
	(properties
		sel_20 {poetryBook}
		sel_0 200
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(1
					(if (gEgo sel_238: 17)
						(gLb2Messager sel_295: 32 1 3)
						(inBooks sel_111:)
					else
						(gLb2Messager sel_295: 32 1 6)
					)
				)
				(4
					(cond 
						((gEgo sel_238: 17) (gLb2Messager sel_295: 32 4 3) (inBooks sel_111:))
						((MuseumRgn sel_646:) (global2 sel_422: inClosedBook))
						(else (return 1))
					)
				)
				(8
					(cond 
						((gEgo sel_238: 17) (gLb2Messager sel_295: 32 4 3) (inBooks sel_111:))
						((MuseumRgn sel_646:) (global2 sel_422: inClosedBook))
						(else (return 1))
					)
				)
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance heimlichBook of Feature
	(properties
		sel_20 {heimlichBook}
		sel_0 200
		sel_213 31
	)
)

(instance chair of Feature
	(properties
		sel_20 {chair}
		sel_1 216
		sel_0 161
		sel_213 1
		sel_6 146
		sel_7 201
		sel_8 176
		sel_9 232
		sel_301 40
	)
)

(instance shelf of Feature
	(properties
		sel_20 {shelf}
		sel_1 24
		sel_0 139
		sel_213 2
		sel_6 90
		sel_8 189
		sel_9 49
		sel_301 40
	)
)

(instance mace of Feature
	(properties
		sel_20 {mace}
		sel_1 12
		sel_0 68
		sel_213 3
		sel_6 52
		sel_8 84
		sel_9 24
		sel_301 40
	)
)

(instance maceChain of Feature
	(properties
		sel_20 {maceChain}
		sel_1 4
		sel_0 26
		sel_213 3
		sel_6 -1
		sel_8 53
		sel_9 9
		sel_301 40
	)
)

(instance leftWeapon of Feature
	(properties
		sel_20 {leftWeapon}
		sel_1 21
		sel_0 28
		sel_213 4
		sel_7 9
		sel_8 56
		sel_9 33
		sel_301 40
	)
)

(instance medalsA of Feature
	(properties
		sel_20 {medalsA}
		sel_1 51
		sel_0 54
		sel_213 5
		sel_6 36
		sel_7 43
		sel_8 73
		sel_9 60
		sel_301 40
	)
)

(instance medalsB of Feature
	(properties
		sel_20 {medalsB}
		sel_1 187
		sel_0 65
		sel_213 6
		sel_6 51
		sel_7 177
		sel_8 75
		sel_9 197
		sel_301 40
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_1 140
		sel_0 127
		sel_213 7
		sel_6 106
		sel_7 83
		sel_8 148
		sel_9 198
		sel_301 40
		sel_302 4
	)
)

(instance light of Feature
	(properties
		sel_20 {light}
		sel_1 160
		sel_0 25
		sel_213 8
		sel_6 -1
		sel_7 144
		sel_8 51
		sel_9 179
		sel_301 40
		sel_302 16
	)
)

(instance chairWolf of Feature
	(properties
		sel_20 {chairWolf}
		sel_1 122
		sel_0 120
		sel_82 27
		sel_213 9
		sel_6 87
		sel_7 111
		sel_8 100
		sel_9 134
		sel_301 40
		sel_302 8
	)
)

(instance lamp of Feature
	(properties
		sel_20 {lamp}
		sel_1 114
		sel_0 120
		sel_82 18
		sel_213 10
		sel_6 95
		sel_7 108
		sel_8 109
		sel_9 121
		sel_301 40
	)
)

(instance intercom of Feature
	(properties
		sel_20 {intercom}
		sel_1 168
		sel_0 120
		sel_82 22
		sel_213 11
		sel_6 94
		sel_7 160
		sel_8 102
		sel_9 176
		sel_301 40
	)
)

(instance blotter of Feature
	(properties
		sel_20 {blotter}
		sel_1 142
		sel_0 120
		sel_82 18
		sel_213 12
		sel_6 96
		sel_7 121
		sel_8 109
		sel_9 163
		sel_301 40
		sel_302 32
	)
)

(instance shelf1 of MyFeature
	(properties
		sel_20 {shelf1}
		sel_1 112
		sel_0 27
		sel_213 13
		sel_6 20
		sel_7 69
		sel_8 35
		sel_9 156
		sel_301 40
		sel_302 64
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 0)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf2 of MyFeature
	(properties
		sel_20 {shelf2}
		sel_1 112
		sel_0 37
		sel_213 14
		sel_6 31
		sel_7 69
		sel_8 44
		sel_9 156
		sel_301 40
		sel_302 128
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 1)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf3 of MyFeature
	(properties
		sel_20 {shelf3}
		sel_1 106
		sel_0 47
		sel_213 15
		sel_6 42
		sel_7 69
		sel_8 52
		sel_9 144
		sel_301 40
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 2)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf4 of MyFeature
	(properties
		sel_20 {shelf4}
		sel_1 112
		sel_0 57
		sel_213 16
		sel_6 52
		sel_7 69
		sel_8 63
		sel_9 156
		sel_301 40
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 3)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf5 of MyFeature
	(properties
		sel_20 {shelf5}
		sel_1 112
		sel_0 68
		sel_213 17
		sel_6 64
		sel_7 69
		sel_8 72
		sel_9 156
		sel_301 40
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 4)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf6a of MyFeature
	(properties
		sel_20 {shelf6a}
		sel_1 84
		sel_0 81
		sel_213 18
		sel_6 76
		sel_7 70
		sel_8 86
		sel_9 98
		sel_301 40
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 5)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf6b of MyFeature
	(properties
		sel_20 {shelf6b}
		sel_1 107
		sel_0 80
		sel_213 19
		sel_6 76
		sel_7 98
		sel_8 85
		sel_9 117
		sel_301 40
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 6)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf6c of MyFeature
	(properties
		sel_20 {shelf6c}
		sel_1 127
		sel_0 78
		sel_213 20
		sel_6 74
		sel_7 119
		sel_8 83
		sel_9 135
		sel_301 40
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 7)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf6d of MyFeature
	(properties
		sel_20 {shelf6d}
		sel_1 145
		sel_0 78
		sel_213 21
		sel_6 74
		sel_7 136
		sel_8 83
		sel_9 154
		sel_301 40
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 8)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf7 of MyFeature
	(properties
		sel_20 {shelf7}
		sel_1 111
		sel_0 89
		sel_213 22
		sel_6 82
		sel_7 68
		sel_8 96
		sel_9 155
		sel_301 40
		sel_302 512
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 9)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance shelf8 of MyFeature
	(properties
		sel_20 {shelf8}
		sel_1 111
		sel_0 99
		sel_213 23
		sel_6 89
		sel_7 68
		sel_8 110
		sel_9 155
		sel_301 40
		sel_302 256
		sel_303 123
		sel_304 115
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(= local2 10)
				(global2 sel_422: inBooks)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance weapons1 of Feature
	(properties
		sel_20 {weapons1}
		sel_1 241
		sel_0 60
		sel_213 24
		sel_6 43
		sel_7 200
		sel_8 69
		sel_9 217
		sel_301 40
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShocked 0 0)
					else
						(return 1)
					)
				)
				(8 (gLb2Messager sel_295: 39 8))
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance weapons2 of Feature
	(properties
		sel_20 {weapons2}
		sel_1 21
		sel_0 28
		sel_213 36
		sel_6 40
		sel_7 215
		sel_8 62
		sel_9 230
		sel_301 40
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShocked 0 1)
					else
						(return 1)
					)
				)
				(8 (gLb2Messager sel_295: 39 8))
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance weapons3 of Feature
	(properties
		sel_20 {weapons3}
		sel_1 21
		sel_0 28
		sel_213 37
		sel_6 37
		sel_7 231
		sel_8 83
		sel_9 245
		sel_301 40
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShocked 0 2)
					else
						(return 1)
					)
				)
				(8 (gLb2Messager sel_295: 39 8))
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance weapons4 of Feature
	(properties
		sel_20 {weapons4}
		sel_1 21
		sel_0 28
		sel_213 38
		sel_6 36
		sel_7 246
		sel_8 73
		sel_9 278
		sel_301 40
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShocked 0 3)
					else
						(return 1)
					)
				)
				(8 (gLb2Messager sel_295: 39 8))
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance weaponsB of Feature
	(properties
		sel_20 {weaponsB}
		sel_1 305
		sel_0 53
		sel_213 26
		sel_6 27
		sel_7 297
		sel_8 115
		sel_9 314
		sel_301 40
	)
	
	(method (sel_300 param1)
		(return
			(switch param1
				(4
					(if (MuseumRgn sel_646:)
						(global2 sel_146: sShocked 0 4)
					else
						(return 1)
					)
				)
				(8 (gLb2Messager sel_295: 39 8))
				(else  (super sel_300: param1))
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		sel_20 {southExit}
		sel_6 185
		sel_7 46
		sel_8 189
		sel_9 319
		sel_33 11
		sel_583 3
		sel_213 42
	)
)

(instance eastExit of ExitFeature
	(properties
		sel_20 {eastExit}
		sel_6 132
		sel_7 315
		sel_8 179
		sel_9 319
		sel_33 14
		sel_583 2
		sel_213 42
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
