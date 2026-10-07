;;; Sierra Script 1.0 - (do not remove this comment)
(script# 20)
(include sci.sh)
(use Main)
(use Inset)
(use CueObj)
(use User)
(use View)
(use Obj)

(public
	inNotebook 0
)

(local
	local0
	local1
	local2
	local3
	theSel_617_2
	theSel_1
	theSel_0
	local7
	theTheSel_617_2
	local9
	local10
)
(procedure (localproc_03c0 &tmp temp0 temp1 temp2)
	(backPage sel_102:)
	(morePage sel_102:)
	(DrawPic 851)
	(notebookList sel_119: 617 0)
	(Display {} 108 local7)
	(= local7
		(Display
			@global136
			100
			(- 160 (* 7 (StrLen @global136)))
			170
			105
			global119
			102
			global157
			107
		)
	)
	(= local2 (= temp0 (* (- local0 1) 8)))
	(while
		(and
			(< local2 (+ 8 temp0))
			(= temp1 (Memory memPEEK (+ local1 (* 2 local2))))
		)
		(if
			((= temp2 (notebookList sel_64: (mod local2 8)))
				sel_116: 617
			)
			(temp2 sel_543: (mod local2 8) temp1)
		)
		(++ local2)
	)
	(if
		(and
			(== (mod local2 8) 0)
			(Memory memPEEK (+ local1 (* 2 local2)))
		)
		(morePage sel_216:)
	)
)

(procedure (localproc_049c param1)
	(= local10 param1)
	(switch param1
		(1
			(peopleTab
				sel_216: (if (> (peopleTab sel_1?) 100) 1 else 0)
			)
			(= local1 @global202)
		)
		(2
			(placesTab
				sel_216: (if (> (placesTab sel_1?) 100) 1 else 0)
			)
			(= local1 @global220)
		)
		(3
			(thingsTab
				sel_216: (if (> (thingsTab sel_1?) 100) 1 else 0)
			)
			(= local1 @global228)
		)
		(4
			(miscTab
				sel_216: (if (> (miscTab sel_1?) 100) 1 else 0)
			)
			(= local1 @global263)
		)
	)
	(titlePage sel_102:)
	(= local0 1)
	(localproc_03c0)
)

(class NotebookItem of Obj
	(properties
		sel_20 {NotebookItem}
		sel_617 0
		sel_1 0
		sel_0 0
		sel_7 0
		sel_9 0
		sel_6 0
		sel_8 0
	)
	
	(method (sel_110)
		(notebookList sel_118: self)
		(super sel_110:)
	)
	
	(method (sel_543 param1 theSel_617 &tmp temp0 temp1 [temp2 40] temp42 temp43 temp44 temp45)
		(if (> theSel_617 1088)
			(= temp45 (- theSel_617 1088))
			(= temp42 857)
			(= temp43 (/ (- temp45 1) 16))
			(= temp44 (mod (- temp45 1) 16))
			(= sel_617 (- theSel_617 1024))
			(self sel_153: param1 temp42 temp43 temp44)
			(DrawCel temp42 temp43 temp44 sel_1 sel_0)
		else
			(= sel_617 theSel_617)
			(= temp0 (/ sel_617 256))
			(= temp1 (mod sel_617 256))
			(self sel_153: param1)
			(Message msgGET 20 temp0 1 0 temp1 @temp2)
			(Display
				@temp2
				105
				10
				100
				sel_1
				sel_0
				102
				(if (== theSel_617_2 theSel_617) global160 else 0)
				106
				100
			)
		)
	)
	
	(method (sel_133 param1 &tmp temp0)
		(cond 
			((param1 sel_73?) (return 1))
			(
			(and (& (param1 sel_31?) $4000) (self sel_218: param1)) (param1 sel_73: 1) (self sel_300: (param1 sel_37?)))
		)
		(return (param1 sel_73?))
	)
	
	(method (sel_300 param1 &tmp [temp0 100] temp100 temp101)
		(switch param1
			(13 (inNotebook sel_300: 13))
			(4
				(if (< sel_617 256)
					(= theSel_617_2 0)
					(if (< (StrLen @global136) 16)
						(Format @global136 {%s%c} @global136 sel_617)
						(Display {} 108 local7)
						(= local7
							(Display
								@global136
								100
								(- 160 (* 7 (StrLen @global136)))
								170
								105
								global119
								102
								global157
								107
							)
						)
					)
				else
					(if (== theSel_617_2 sel_617)
						(inNotebook sel_300: 13)
						(return)
					)
					(Display {} 108 local7)
					(= global136 0)
					(= temp100 (/ theSel_617_2 256))
					(= temp101 (mod theSel_617_2 256))
					(if
						(and
							theSel_617_2
							(notebookList sel_120: 96 oldOnePresent theSel_617_2)
						)
						(Message msgGET 20 temp100 1 0 temp101 @temp0)
						(Display @temp0 105 10 100 theSel_1 theSel_0 106 100)
					)
					(= theSel_617_2 sel_617)
					(= theSel_1 sel_1)
					(= theSel_0 sel_0)
					(= temp100 (/ theSel_617_2 256))
					(= temp101 (mod theSel_617_2 256))
					(Message msgGET 20 temp100 1 0 temp101 @temp0)
					(Display
						@temp0
						105
						10
						100
						theSel_1
						theSel_0
						102
						global160
						106
						100
					)
				)
			)
		)
	)
	
	(method (sel_218 param1)
		(return
			(if
				(and
					(<= sel_7 (param1 sel_1?))
					(<= (param1 sel_1?) sel_9)
					(<= sel_6 (param1 sel_0?))
					(<= (param1 sel_0?) sel_8)
				)
				1
			else
				0
			)
		)
	)
	
	(method (sel_153 param1 param2 param3 param4 &tmp temp0)
		(if (< sel_617 256)
			(= temp0 (if (< param1 4) 65 else 172))
			(= sel_6 (+ (* (mod param1 4) 24) 43))
			(= sel_7 (+ temp0 (if (mod param1 2) 45 else 0)))
			(= sel_8 (+ (CelHigh param2 param3 param4) sel_6))
			(= sel_9 (+ (CelWide param2 param3 param4) sel_7))
			(= sel_1 sel_7)
			(= sel_0 sel_6)
		else
			(= sel_6 (+ (* (mod param1 4) 24) 43))
			(= sel_7 (if (< param1 4) 65 else 182))
			(= sel_8 (+ 5 sel_6))
			(= sel_9 (+ 78 sel_7))
			(= sel_1 sel_7)
			(= sel_0 sel_6)
		)
	)
)

(instance oldOnePresent of Code
	(properties
		sel_20 {oldOnePresent}
	)
	
	(method (sel_57 param1 param2)
		(return (== (param1 sel_617?) param2))
	)
)

(instance notebookList of EventHandler
	(properties
		sel_20 {notebookList}
	)
)

(instance titlePage of View
	(properties
		sel_20 {titlePage}
		sel_1 156
		sel_0 151
		sel_214 20
		sel_2 854
	)
	
	(method (sel_307)
	)
	
	(method (sel_300)
		(inNotebook sel_300: &rest)
	)
)

(instance morePage of View
	(properties
		sel_20 {morePage}
		sel_1 237
		sel_0 153
		sel_214 20
		sel_2 851
		sel_3 4
		sel_4 1
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(++ local0)
				(localproc_03c0)
				(backPage sel_216:)
			)
			(else 
				(inNotebook sel_300: param1)
			)
		)
	)
)

(instance backPage of View
	(properties
		sel_20 {backPage}
		sel_1 85
		sel_0 153
		sel_214 20
		sel_2 851
		sel_3 4
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(-- local0)
				(localproc_03c0)
				(if (== local0 1) (self sel_102:) else (self sel_216:))
			)
			(else 
				(inNotebook sel_300: param1)
			)
		)
	)
)

(instance peopleTab of View
	(properties
		sel_20 {peopleTab}
		sel_1 262
		sel_0 58
		sel_214 20
		sel_2 851
		sel_3 1
		sel_60 5
		sel_14 16
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (localproc_049c 1))
			(else 
				(inNotebook sel_300: param1)
			)
		)
	)
	
	(method (sel_216 param1)
		(if (and argc param1)
			(self sel_155: 2 sel_1: 59)
		else
			(placesTab sel_155: 1 sel_1: 262)
			(thingsTab sel_155: 1 sel_1: 262)
			(miscTab sel_155: 1 sel_1: 262)
		)
	)
)

(instance placesTab of View
	(properties
		sel_20 {placesTab}
		sel_1 262
		sel_0 92
		sel_214 20
		sel_2 851
		sel_3 1
		sel_4 1
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (localproc_049c 2))
			(else 
				(inNotebook sel_300: param1)
			)
		)
	)
	
	(method (sel_216 param1)
		(if (and argc param1)
			(self sel_155: 2 sel_1: 59)
			(peopleTab sel_216: 1)
		else
			(thingsTab sel_155: 1 sel_1: 262)
			(miscTab sel_155: 1 sel_1: 262)
		)
	)
)

(instance thingsTab of View
	(properties
		sel_20 {thingsTab}
		sel_1 262
		sel_0 128
		sel_214 20
		sel_2 851
		sel_3 1
		sel_4 2
		sel_60 4
		sel_14 16
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (localproc_049c 3))
			(else 
				(inNotebook sel_300: param1)
			)
		)
	)
	
	(method (sel_216 param1)
		(if (and argc param1)
			(self sel_155: 2 sel_1: 59)
			(placesTab sel_216: 1)
		else
			(miscTab sel_155: 1 sel_1: 262)
		)
	)
)

(instance miscTab of View
	(properties
		sel_20 {miscTab}
		sel_1 262
		sel_0 153
		sel_214 20
		sel_2 851
		sel_3 1
		sel_4 3
		sel_60 3
		sel_14 16
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4 (localproc_049c 4))
			(else 
				(inNotebook sel_300: param1)
			)
		)
	)
	
	(method (sel_216 param1)
		(if (and argc param1)
			(self sel_155: 2 sel_1: 59)
			(thingsTab sel_216: 1)
		)
	)
)

(instance backUp of Feature
	(properties
		sel_20 {backUp}
		sel_1 1
		sel_0 1
		sel_6 175
		sel_7 41
		sel_8 189
		sel_9 279
	)
	
	(method (sel_307)
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(StrAt @global136 (- (StrLen @global136) 1) 0)
				(Display {} 108 local7)
				(= local7
					(Display
						@global136
						100
						(- 160 (* 7 (StrLen @global136)))
						170
						105
						global119
						102
						global157
						107
					)
				)
			)
			(else 
				(inNotebook sel_300: param1)
			)
		)
	)
)

(instance inNotebook of Inset
	(properties
		sel_20 {inNotebook}
		sel_408 851
		sel_214 20
	)
	
	(method (sel_110)
		(if
			(= local9
				(!= (((gIconBar sel_64: 0) sel_33?) sel_2?) 6)
			)
			(proc0_8 1)
		)
		(gGame sel_587:)
		(gIconBar sel_233: 7 sel_177: 2 0)
		(super sel_110: &rest)
		(= theTheSel_617_2 0)
		(= global136 0)
		(= local2 0)
		(while (< local2 8)
			((NotebookItem sel_109:) sel_153: local2 sel_110:)
			(++ local2)
		)
		(backUp sel_110:)
		(titlePage sel_110: sel_102:)
		(morePage sel_110: sel_102:)
		(backPage sel_110: sel_102:)
		(peopleTab sel_110: sel_313:)
		(placesTab sel_110: sel_313:)
		(thingsTab sel_110: sel_313:)
		(miscTab sel_110: sel_313:)
		(localproc_049c (if local10 local10 else 1))
		(gLb2MDH sel_129: self)
		(gLb2KDH sel_129: self)
		(gLb2DH sel_129: self)
		(gIconBar sel_178: (gIconBar sel_64: 2))
		(gGame sel_197: 2)
		(self sel_57:)
	)
	
	(method (sel_57 &tmp eventSel_109)
		(gPseudoMouse sel_528: 2)
		(while (not theTheSel_617_2)
			(Animate (gSel_561 sel_24?) 1)
			(if global37 (= global37 0) (gSel_561 sel_119: 243))
			(if sel_142 (sel_142 sel_57:))
			(= global24 (= eventSel_109 (Event sel_109:)))
			(eventSel_109 sel_148:)
			(if
			(and gPseudoMouse (gTheDoits sel_122: gPseudoMouse))
				(gPseudoMouse sel_57:)
			)
			(gUser sel_237: 1)
			(MapKeyToDir eventSel_109)
			(if (== (eventSel_109 sel_31?) 256)
				(eventSel_109
					sel_31: 4
					sel_37: (if (& (eventSel_109 sel_61?) $0003) 27 else 13)
					sel_61: 0
				)
			)
			(if (& (eventSel_109 sel_31?) $0040)
				(if
					(and
						(== (eventSel_109 sel_37?) 0)
						(& (eventSel_109 sel_31?) $0004)
					)
					(gIconBar sel_133: eventSel_109)
				else
					(gPseudoMouse sel_133: eventSel_109)
				)
			else
				(gIconBar sel_133: eventSel_109)
				(if (& (eventSel_109 sel_31?) $4000)
					(OnMeAndLowY sel_110:)
					(gSel_561 sel_119: 96 OnMeAndLowY eventSel_109)
					(gSel_562 sel_119: 96 OnMeAndLowY eventSel_109)
					(cond 
						((notebookList sel_133: eventSel_109))
						((OnMeAndLowY sel_348?) ((OnMeAndLowY sel_348?) sel_133: eventSel_109))
					)
				)
			)
			(eventSel_109 sel_111:)
		)
		(gPseudoMouse sel_528: 5)
		(return theTheSel_617_2)
	)
	
	(method (sel_111)
		(notebookList sel_111:)
		(super sel_111: &rest)
		(Animate (gSel_561 sel_24?) 0)
		(= gSel_45 (+ global86 (GetTime)))
		(if local9 (proc0_8 0))
		(gGame sel_588: 1)
		(gIconBar sel_177: 7)
		(DisposeScript 20)
	)
	
	(method (sel_300 param1)
		(switch param1
			(13
				(gGame sel_197: global21)
				(if (not theSel_617_2) (= theSel_617_2 -1))
				(= theTheSel_617_2 theSel_617_2)
				(inNotebook sel_111:)
			)
		)
	)
)
