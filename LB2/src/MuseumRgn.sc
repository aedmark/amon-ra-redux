;;; Sierra Script 1.0 - (do not remove this comment)
(script# 90)
(include sci.sh)
(use Main)
(use n027)
(use Scaler)
(use PolyPath)
(use StopWalk)
(use Timer)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	MuseumRgn 0
	aCountess 1
	aOlympia 2
	aORiley 3
	aTut 4
	aWatney 5
	aYvette 6
	aZiggy 7
	fumeTimer 13
	meetingTimer 15
)

(local
	[local0 100] = [350 632 4 0 1 360 0 638 0 0 370 0 0 0 635 420 7 -1 0 624 500 15 0 608 0 510 512 128 64 31 520 0 0 575 0 530 -1 0 127 0 430 32 -1 0 94 440 28 33 64 0 448 24 0 99 0 450 0 0 103 16 454 0 111 0 0 480 95 0 0 0 490 63 0 0 0 550 0 0 639 0 600 2 12 -1 0 610 8 0 3 0 630 0 7 0 0 650 0 0 13]
	[theTheSel_652 120] = [350 2 420 370 0 360 360 1 0 350 0 0 370 4 0 0 0 350 420 8 350 430 0 500 500 16 420 0 510 0 510 32 530 550 520 500 520 64 0 0 510 0 530 512 600 0 510 0 430 1 480 420 0 440 440 2 448 430 490 0 448 4 450 0 440 0 450 8 0 0 448 454 454 16 0 450 0 0 480 32 430 0 0 0 490 64 0 0 440 0 550 128 0 0 510 0 600 1 650 610 530 0 610 4 630 0 600 0 630 8 0 610 0 0 650 2 0 0 600]
	[local220 40] = [350 0 360 0 370 0 420 0 500 0 510 0 520 0 530 0 430 0 440 0 448 0 450 0 454 0 480 0 490 0 550 0 600 0 610 0 630 0 650]
)
(procedure (localproc_0202 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1
		(switch param1
			(1 5)
			(2 6)
			(3 2)
		))
	(= temp0 0)
	(return
		(while (< temp0 21)
			(if
				(==
					(= temp2
						(switch param1
							(1 [local0 (* temp0 temp1)])
							(2
								[theTheSel_652 (* temp0 temp1)]
							)
							(3 [local220 (* temp0 temp1)])
						)
					)
					param2
				)
				(return (* temp0 temp1))
			)
			(++ temp0)
		)
	)
)

(class MuseumRgn of Rgn
	(properties
		sel_20 {MuseumRgn}
		sel_142 0
		sel_40 0
		sel_214 -1
		sel_213 0
		sel_135 0
		sel_406 0
		sel_407 0
		sel_631 0
		sel_632 0
		sel_633 0
		sel_634 0
		sel_635 0
		sel_636 0
		sel_637 0
		sel_638 0
		sel_639 0
		sel_640 0
		sel_641 0
		sel_642 0
		sel_643 0
		sel_678 0
		sel_679 0
	)
	
	(method (sel_110)
		(super sel_110:)
		(self sel_645:)
		(if (not (proc0_2 6)) ((ScriptID 90 1) sel_110:))
		((ScriptID 90 2) sel_110:)
		((ScriptID 90 3) sel_110:)
		((ScriptID 90 4) sel_110:)
		(if (not (proc0_2 3)) ((ScriptID 90 5) sel_110:))
		(if (not (proc0_2 5)) ((ScriptID 90 6) sel_110:))
		(if (not (proc0_2 2)) ((ScriptID 90 7) sel_110:))
		(gLb2KDH sel_129: self)
		(if (not (gTimers sel_122: wanderTimer))
			(wanderTimer sel_162: wanderTimer 120)
		)
	)
	
	(method (sel_111)
		(if (gTimers sel_122: wanderTimer)
			(wanderTimer sel_111: sel_81:)
		)
		(super sel_111:)
	)
	
	(method (sel_399 param1)
		(= sel_406
			(proc999_5
				param1
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
		)
		(= sel_407 0)
		(gLb2KDH sel_81: self)
		(if (global2 sel_259?)
			(DisposeScript (+ 2000 gSel_40))
		)
		(if sel_631
			(sel_631 sel_111:)
			(= sel_631 0)
			(if (IsObject sel_639) (sel_639 sel_111:))
			(= sel_639 0)
			(DisposeScript sel_632)
		)
		(if sel_633
			(sel_633 sel_111:)
			(= sel_633 0)
			(if (IsObject sel_640) (sel_640 sel_111:))
			(= sel_640 0)
			(DisposeScript sel_634)
		)
		(if sel_635
			(sel_635 sel_111:)
			(= sel_635 0)
			(if (IsObject sel_641) (sel_641 sel_111:))
			(= sel_641 0)
			(DisposeScript sel_636)
		)
		(if sel_637
			(sel_637 sel_111:)
			(= sel_637 0)
			(if (IsObject sel_642) (sel_642 sel_111:))
			(= sel_642 0)
			(DisposeScript sel_638)
		)
	)
	
	(method (sel_644 param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(if (< argc 2)
				(= temp0 (localproc_0202 3 [param1 0]))
				(return [local220 (++ temp0)])
			else
				(= temp3 [param1 0])
				(= temp4 [param1 1])
				(= temp1 1)
				(while (and temp3 (<= temp1 argc))
					(if (> temp3 0)
						(= [local220 (+ temp0 1)]
							(+
								[local220 (+ (= temp0 (localproc_0202 3 temp3)) 1)]
								temp4
							)
						)
					)
					(= temp3 [param1 (++ temp1)])
					(= temp4 [param1 (++ temp1)])
				)
			)
		)
	)
	
	(method (sel_680 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(if
			(not
				(= temp1
					(switch param1
						((global2 sel_409?)
							(MuseumRgn sel_631?)
						)
						((global2 sel_410?)
							(MuseumRgn sel_633?)
						)
						((global2 sel_411?)
							(MuseumRgn sel_635?)
						)
						((global2 sel_412?)
							(MuseumRgn sel_637?)
						)
						(gSel_40 (global2 sel_259?))
						(else  0)
					)
				)
			)
			(return 1)
		)
		(= temp0 1)
		(= temp3 0)
		(while (and temp0 (< temp3 (temp1 sel_86?)))
			(if
				(or
					(and
						(== ((= temp2 (temp1 sel_64: temp3)) sel_31?) 3)
						(not (AvoidPath param2 param3 temp2))
					)
					(and
						(!= (temp2 sel_31?) 3)
						(AvoidPath param2 param3 temp2)
					)
				)
				(= temp0 0)
			)
			(++ temp3)
		)
		(if (not temp0)
			(switch param1
				((global2 sel_409?)
					(= sel_678 ((MuseumRgn sel_639?) sel_621?))
					(= sel_679 ((MuseumRgn sel_639?) sel_622?))
				)
				((global2 sel_410?)
					(= sel_678 ((MuseumRgn sel_640?) sel_621?))
					(= sel_679 ((MuseumRgn sel_640?) sel_622?))
				)
				((global2 sel_411?)
					(= sel_678 ((MuseumRgn sel_641?) sel_621?))
					(= sel_679 ((MuseumRgn sel_641?) sel_622?))
				)
				((global2 sel_412?)
					(= sel_678 ((MuseumRgn sel_642?) sel_621?))
					(= sel_679 ((MuseumRgn sel_642?) sel_622?))
				)
				(gSel_40
					(= sel_678 ((MuseumRgn sel_643?) sel_621?))
					(= sel_679 ((MuseumRgn sel_643?) sel_622?))
				)
			)
		)
		(return temp0)
	)
	
	(method (sel_645)
		(if (global2 sel_259?) ((global2 sel_259?) sel_111:))
		(if sel_631 (sel_631 sel_111:))
		(if sel_633 (sel_633 sel_111:))
		(if sel_635 (sel_635 sel_111:))
		(if sel_637 (sel_637 sel_111:))
		(global2 sel_259: (List sel_109:))
		((ScriptID (+ 2000 gSel_40) 0)
			sel_57: (global2 sel_259?)
		)
		(if
			(proc999_5
				(global2 sel_409?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_632 (+ 2000 (global2 sel_409?)))
			((ScriptID sel_632 0)
				sel_57: (= sel_631 (List sel_109:))
			)
		)
		(if
			(proc999_5
				(global2 sel_410?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_634 (+ 2000 (global2 sel_410?)))
			((ScriptID sel_634 0)
				sel_57: (= sel_633 (List sel_109:))
			)
		)
		(if
			(proc999_5
				(global2 sel_411?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_636 (+ 2000 (global2 sel_411?)))
			((ScriptID sel_636 0)
				sel_57: (= sel_635 (List sel_109:))
			)
		)
		(if
			(proc999_5
				(global2 sel_412?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_638 (+ 2000 (global2 sel_412?)))
			((ScriptID sel_638 0)
				sel_57: (= sel_637 (List sel_109:))
			)
		)
		(= sel_643 (ScriptID (+ 2000 gSel_40) 1))
		(if
			(proc999_5
				(global2 sel_409?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_639 (ScriptID sel_632 1))
		)
		(if
			(proc999_5
				(global2 sel_410?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_640 (ScriptID sel_634 1))
		)
		(if
			(proc999_5
				(global2 sel_411?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_641 (ScriptID sel_636 1))
		)
		(if
			(proc999_5
				(global2 sel_412?)
				335
				340
				350
				355
				360
				370
				400
				420
				500
				510
				520
				525
				530
				540
				550
				560
				565
				430
				435
				440
				448
				450
				454
				455
				456
				460
				480
				490
				521
				600
				610
				620
				630
				640
				650
				666
				660
				700
				710
				715
				720
				730
				740
			)
			(= sel_642 (ScriptID sel_638 1))
		)
	)
	
	(method (sel_646)
		(return
			(if
				(proc999_5
					gSel_40
					((ScriptID 90 1) sel_620?)
					((ScriptID 90 2) sel_620?)
					((ScriptID 90 3) sel_620?)
					((ScriptID 90 4) sel_620?)
					((ScriptID 90 5) sel_620?)
					((ScriptID 90 6) sel_620?)
					((ScriptID 90 7) sel_620?)
				)
				(gLb2Messager sel_295: 16 46 0 0 0 0)
				(return 0)
			else
				(return 1)
			)
		)
	)
	
	(method (sel_647 param1)
		(switch param1
			(gSel_40 (global2 sel_259?))
			((global2 sel_409?) sel_631)
			((global2 sel_410?) sel_633)
			((global2 sel_411?) sel_635)
			((global2 sel_412?) sel_637)
		)
	)
)

(class MuseumActor of Actor
	(properties
		sel_20 {MuseumActor}
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
		sel_52 2
		sel_2 -1
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 0
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
		sel_244 6
		sel_142 0
		sel_245 0
		sel_135 0
		sel_321 0
		sel_322 0
		sel_15 -32768
		sel_249 0
		sel_250 0
		sel_51 3
		sel_323 770
		sel_53 6
		sel_324 0
		sel_325 0
		sel_56 0
		sel_59 0
		sel_326 0
		sel_327 0
		sel_328 0
		sel_648 0
		sel_649 0
		sel_619 0
		sel_620 0
		sel_650 0
		sel_651 0
		sel_652 0
		sel_653 0
		sel_654 0
		sel_655 0
		sel_656 0
		sel_657 0
		sel_533 0
	)
	
	(method (sel_110 &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 [temp7 5])
		(self
			sel_2: (if (== sel_620 gSel_40) sel_648 else 828)
			sel_316:
			sel_330:
			sel_15: 0
			sel_161: StopWalk -1
		)
		(if (gEgo sel_322?)
			(= temp2 (/ (* 110 ((gEgo sel_322?) sel_577?)) 100))
			(= temp3 ((gEgo sel_322?) sel_575?))
			(= temp4
				(/ (* 110 (+ 1 ((gEgo sel_322?) sel_578?))) 100)
			)
			(= temp5 ((gEgo sel_322?) sel_576?))
			(self sel_320: Scaler temp2 temp4 temp3 temp5)
		else
			(self sel_320: -1 gEgo)
			(= sel_106 (/ (* 110 sel_106) 100))
		)
		(super sel_110: &rest)
		(cond 
			((not sel_649)
				(cond 
					(sel_619
						(cond 
							((== sel_620 gSel_40) 0)
							((self sel_660:)
								(if (not (MuseumRgn sel_680: sel_620 sel_1 sel_0))
									(self
										sel_153: (MuseumRgn sel_678?) (MuseumRgn sel_679?)
									)
								)
							)
							(else (self sel_153: 160 165))
						)
						(if (> (MuseumRgn sel_644: sel_620) 1)
							(= temp6 (- temp6 15))
						)
						(self sel_664: sel_652 self)
					)
					((and (== sel_620 -1) (Random 0 1))
						(cond 
							((== sel_620 gSel_40)
								(if (not (MuseumRgn sel_680: sel_620 sel_1 sel_0))
									(self
										sel_153: (MuseumRgn sel_678?) (MuseumRgn sel_679?)
									)
								)
							)
							((self sel_660:)
								(if (not (MuseumRgn sel_680: sel_620 sel_1 sel_0))
									(self
										sel_153: (MuseumRgn sel_678?) (MuseumRgn sel_679?)
									)
								)
							)
							(else 0)
						)
						(self sel_664:)
					)
				)
			)
			(sel_652
				(cond 
					((== sel_620 gSel_40)
						(if (not (MuseumRgn sel_680: sel_620 sel_1 sel_0))
							(self
								sel_153: (MuseumRgn sel_678?) (MuseumRgn sel_679?)
							)
						)
					)
					((self sel_660:)
						(if (not (MuseumRgn sel_680: sel_620 sel_1 sel_0))
							(self
								sel_153: (MuseumRgn sel_678?) (MuseumRgn sel_679?)
							)
						)
					)
					(else 0)
				)
				(self sel_618: sel_652 self)
			)
			((== sel_620 sel_651) (= sel_651 0))
		)
	)
	
	(method (sel_218)
		(return
			(if (== sel_2 828)
				(return 0)
			else
				(super sel_218: &rest)
			)
		)
	)
	
	(method (sel_658 param1 &tmp temp0 temp1)
		(= temp0 (self sel_662: param1))
		(= temp1 (* sel_653 5))
		(return
			(cond 
				(
					(and
						(& [local0 (++ temp1)] temp0)
						(> [local0 temp1] 0)
					)
					(return 1)
				)
				(
					(and
						(& [local0 (++ temp1)] temp0)
						(> [local0 temp1] 0)
					)
					(return 2)
				)
				(
					(and
						(& [local0 (++ temp1)] temp0)
						(> [local0 temp1] 0)
					)
					(return 3)
				)
				(
					(and
						(& [local0 (++ temp1)] temp0)
						(> [local0 temp1] 0)
					)
					(return 4)
				)
				(else (return 0))
			)
		)
	)
	
	(method (sel_659 param1)
		(cond 
			(
				(proc999_5
					sel_620
					420
					500
					510
					520
					525
					530
					540
					550
					560
					565
					335
					340
					350
					355
					360
					370
					400
				)
				(cond 
					(
						(proc999_5
							param1
							430
							435
							440
							448
							450
							454
							455
							456
							460
							480
							490
							521
						)
						(= sel_651 420)
					)
					((proc999_5 param1 600 610 620 630 640 650 666) (= sel_651 530))
				)
			)
			(
				(proc999_5
					sel_620
					430
					435
					440
					448
					450
					454
					455
					456
					460
					480
					490
					521
				)
				(if
					(not
						(proc999_5
							param1
							430
							435
							440
							448
							450
							454
							455
							456
							460
							480
							490
							521
						)
					)
					(= sel_651 430)
				)
			)
			(
				(and
					(proc999_5 sel_620 600 610 620 630 640 650 666)
					(not (proc999_5 param1 600 610 620 630 640 650 666))
				)
				(= sel_651 600)
			)
		)
		(return sel_651)
	)
	
	(method (sel_618 theSel_652 param2 theSel_656 theSel_657)
		(= sel_649 1)
		(if (proc999_5 sel_620 -1 -2) (self sel_182: sel_652))
		(= sel_651 (= sel_652 theSel_652))
		(if (< argc 2) (= param2 0))
		(if (> argc 2)
			(= sel_656 theSel_656)
			(= sel_657 theSel_657)
		else
			(= sel_657 (= sel_656 -1))
		)
		(self sel_146: (TravelToRoom sel_109:) param2)
	)
	
	(method (sel_660)
		(switch sel_620
			((global2 sel_409?) 1)
			((global2 sel_411?) 3)
			((global2 sel_410?) 2)
			((global2 sel_412?) 4)
			(else  0)
		)
	)
	
	(method (sel_182 theSel_620 &tmp temp0 theSel_620_2)
		(if (proc999_5 theSel_620 -1 -2)
			(if (MuseumRgn sel_644: sel_620)
				(MuseumRgn sel_644: sel_620 -1)
			)
			(= sel_652 sel_620)
			(= sel_620 theSel_620)
			(= sel_649 (= sel_619 0))
			(self sel_146: 0)
			(return)
		else
			(= sel_619 0)
			(self sel_146: 0)
			(= theSel_620_2 sel_620)
			(= sel_620 theSel_620)
			(if
				(and
					(> theSel_620_2 0)
					(!= theSel_620_2 355)
					(!= theSel_620 355)
				)
				(self sel_663: sel_620)
				(= sel_650 (self sel_661: (self sel_658: theSel_620_2)))
				(MuseumRgn sel_644: sel_650 -1)
			)
			(= sel_2 (if (== sel_620 gSel_40) sel_648 else 828))
			(MuseumRgn sel_644: sel_620 1)
		)
	)
	
	(method (sel_661 param1)
		(return [theTheSel_652 (+ (* sel_653 6) param1 1)])
	)
	
	(method (sel_662 param1 &tmp temp0)
		(= temp0 (localproc_0202 2 param1))
		(return [theTheSel_652 (++ temp0)])
	)
	
	(method (sel_663 &tmp temp0)
		(= sel_653 (/ (= temp0 (localproc_0202 2 sel_620)) 6))
	)
	
	(method (sel_664 theTheSel_652_2 param2 theSel_656 theSel_657 &tmp theSel_652)
		(if (not argc)
			(while
				(==
					sel_620
					(= theSel_652 [theTheSel_652 (* (Random 0 22) 6)])
				)
				0
			)
		else
			(= theSel_652 theTheSel_652_2)
		)
		(= sel_649 0)
		(= sel_619 1)
		(= sel_651 (= sel_652 theSel_652))
		(if (< argc 2) (= param2 0))
		(if (> argc 2)
			(= sel_656 theSel_656)
			(= sel_657 theSel_657)
		else
			(= sel_657 (= sel_656 -1))
		)
		(= sel_533 10)
		(self sel_146: (TravelToRoom sel_109:) param2)
	)
)

(instance aCountess of MuseumActor
	(properties
		sel_20 {aCountess}
		sel_213 1
		sel_214 1884
		sel_323 514
		sel_648 813
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 2)
			(return
				(if (not (proc0_3 112))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
		)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(switch temp0
				(258
					(cond 
						((proc0_2 134)
							(if (proc27_0 0 global364)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
								(proc27_1 0 @global364)
							)
						)
						((proc27_0 0 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
							(proc27_1 0 @global297)
						)
					)
				)
				(264
					(cond 
						((or (proc0_2 143) (proc0_2 72))
							(if (proc27_0 0 global366)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 74 0 0 sel_214)
								(proc27_1 0 @global366)
							)
						)
						((proc27_0 0 global303) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 9 0 0 sel_214)
							(proc27_1 0 @global303)
						)
					)
				)
				(267
					(cond 
						((or (proc0_2 158) (proc0_2 67))
							(if (proc27_0 0 global365)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 71 0 0 sel_214)
								(proc27_1 0 @global365)
							)
						)
						((proc27_0 0 global306) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 12 0 0 sel_214)
							(proc27_1 0 @global306)
						)
					)
				)
				(else 
					(cond 
						(
						(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
						((proc27_0 0 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 0 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)
	
	(method (sel_145)
		(self sel_664:)
	)
	
	(method (sel_664 param1 param2 &tmp temp0 temp1)
		(asm
			lap      argc
			not     
			bt       code_1384
			lap      param1
			not     
			bnt      code_1427
code_1384:
			pToa     sel_620
			sat      temp1
code_1388:
			lst      temp1
			pToa     sel_620
			eq?     
			bnt      code_13df
			ldi      0
			sat      temp1
			pushi    2
			pushi    1
			pushi    100
			callk    Random,  4
			sat      temp0
			lsg      global123
			ldi      3
			eq?     
			bnt      code_13d1
			lst      temp0
			ldi      5
			le?     
			bnt      code_13b4
			ldi      450
			sat      temp1
			jmp      code_1388
code_13b4:
			lst      temp0
			ldi      10
			le?     
			bnt      code_13c3
			ldi      454
			sat      temp1
			jmp      code_1388
code_13c3:
			lst      temp0
			ldi      50
			le?     
			bnt      code_1388
			ldi      500
			sat      temp1
			jmp      code_1388
code_13d1:
			lst      temp0
			ldi      40
			le?     
			bnt      code_1388
			ldi      500
			sat      temp1
			jmp      code_1388
code_13df:
			lat      temp1
			bnt      code_140d
			pTos     sel_620
			ldi      65535
			eq?     
			bnt      code_1400
			pTos     sel_652
			ldi      0
			gt?     
			bnt      code_13fc
			pushi    #sel_182
			pushi    1
			pTos     sel_652
			self     6
code_13fc:
			ldi      0
			aTop     sel_652
code_1400:
			pushi    #sel_664
			pushi    2
			lst      temp1
			pushSelf
			super    MuseumActor,  8
			jmp      code_1432
code_140d:
			pTos     sel_620
			ldi      65535
			ne?     
			bnt      code_1418
			pToa     sel_620
			aTop     sel_652
code_1418:
			pushi    #sel_182
			pushi    1
			pushi    65535
			self     6
			ldi      0
			aTop     sel_619
			jmp      code_1432
code_1427:
			pushi    #sel_664
			pushi    1
			lsp      param1
			&rest    param2
			super    MuseumActor,  6
code_1432:
			ret     
		)
	)
)

(instance aOlympia of MuseumActor
	(properties
		sel_20 {aOlympia}
		sel_213 1
		sel_214 1892
		sel_103 1
		sel_648 820
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(switch temp0
				(258
					(cond 
						((proc0_2 134)
							(if (proc27_0 3 global364)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
								(proc27_1 3 @global364)
							)
						)
						((proc27_0 3 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
							(proc27_1 3 @global297)
						)
					)
				)
				(259
					(cond 
						((or (proc0_2 171) (proc0_2 12))
							(if (proc27_0 3 global363)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 69 0 0 sel_214)
								(proc27_1 3 @global363)
							)
						)
						((proc27_0 3 global298) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 4 0 0 sel_214)
							(proc27_1 3 @global298)
						)
					)
				)
				(264
					(cond 
						((or (proc0_2 143) (proc0_2 72))
							(if (proc27_0 3 global366)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 74 0 0 sel_214)
								(proc27_1 3 @global366)
							)
						)
						((proc27_0 3 global303) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 9 0 0 sel_214)
							(proc27_1 3 @global303)
						)
					)
				)
				(266
					(cond 
						((or (proc0_2 161) (proc0_2 68))
							(if (proc27_0 3 global367)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 73 0 0 sel_214)
								(proc27_1 3 @global367)
							)
						)
						((proc27_0 3 global305) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 11 0 0 sel_214)
							(proc27_1 3 @global305)
						)
					)
				)
				(267
					(cond 
						((or (proc0_2 158) (proc0_2 67))
							(if (proc27_0 3 global365)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 71 0 0 sel_214)
								(proc27_1 3 @global365)
							)
						)
						((proc27_0 3 global306) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 12 0 0 sel_214)
							(proc27_1 3 @global306)
						)
					)
				)
				(else 
					(cond 
						(
						(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
						((proc27_0 3 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 3 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)
	
	(method (sel_145)
		(self sel_664:)
	)
	
	(method (sel_664 param1 param2 &tmp temp0 temp1)
		(asm
			lap      argc
			not     
			bt       code_1719
			lap      param1
			not     
			bnt      code_17db
code_1719:
			pToa     sel_620
			sat      temp1
code_171d:
			lst      temp1
			pToa     sel_620
			eq?     
			bnt      code_1792
			ldi      0
			sat      temp1
			pushi    2
			pushi    1
			pushi    100
			callk    Random,  4
			sat      temp0
			lsg      global123
			ldi      3
			eq?     
			bnt      code_1775
			lst      temp0
			ldi      15
			le?     
			bnt      code_1749
			ldi      650
			sat      temp1
			jmp      code_171d
code_1749:
			lst      temp0
			ldi      25
			le?     
			bnt      code_1758
			ldi      450
			sat      temp1
			jmp      code_171d
code_1758:
			lst      temp0
			ldi      35
			le?     
			bnt      code_1767
			ldi      454
			sat      temp1
			jmp      code_171d
code_1767:
			lst      temp0
			ldi      85
			le?     
			bnt      code_171d
			ldi      520
			sat      temp1
			jmp      code_171d
code_1775:
			lst      temp0
			ldi      30
			le?     
			bnt      code_1784
			ldi      650
			sat      temp1
			jmp      code_171d
code_1784:
			lst      temp0
			ldi      80
			le?     
			bnt      code_171d
			ldi      520
			sat      temp1
			jmp      code_171d
code_1792:
			lat      temp1
			bnt      code_17c0
			pTos     sel_620
			ldi      65535
			eq?     
			bnt      code_17b3
			pTos     sel_652
			ldi      0
			gt?     
			bnt      code_17af
			pushi    #sel_182
			pushi    1
			pTos     sel_652
			self     6
code_17af:
			ldi      0
			aTop     sel_652
code_17b3:
			pushi    #sel_664
			pushi    2
			lst      temp1
			pushSelf
			super    MuseumActor,  8
			jmp      code_17e6
code_17c0:
			pTos     sel_620
			ldi      65535
			ne?     
			bnt      code_17cc
			pToa     sel_620
			aTop     sel_652
code_17cc:
			pushi    #sel_182
			pushi    1
			pushi    65535
			self     6
			ldi      0
			aTop     sel_619
			jmp      code_17e6
code_17db:
			pushi    #sel_664
			pushi    1
			lsp      param1
			&rest    param2
			super    MuseumActor,  6
code_17e6:
			ret     
		)
	)
)

(instance aORiley of MuseumActor
	(properties
		sel_20 {aORiley}
		sel_213 1
		sel_214 1888
		sel_648 818
	)
	
	(method (sel_110)
		(= sel_323 (if (== sel_2 818) 1282 else 770))
		(super sel_110: &rest)
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 2)
			(return
				(if (not (proc0_3 114))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
		)
		(if (== param1 22)
			(super sel_300: param1)
			(if (gEgo sel_238: 11)
				(gEgo sel_351: 11)
			)
			(return)
		)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(switch temp0
				(258
					(cond 
						((proc0_2 134)
							(if (proc27_0 4 global364)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
								(proc27_1 4 @global364)
							)
						)
						((proc27_0 4 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
							(proc27_1 4 @global297)
						)
					)
				)
				(259
					(cond 
						((or (proc0_2 171) (proc0_2 12))
							(if (proc27_0 4 global363)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 69 0 0 sel_214)
								(proc27_1 4 @global363)
							)
						)
						((proc27_0 4 global298) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 4 0 0 sel_214)
							(proc27_1 4 @global298)
						)
					)
				)
				(264
					(cond 
						((or (proc0_2 143) (proc0_2 72))
							(if (proc27_0 4 global366)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 74 0 0 sel_214)
								(proc27_1 4 @global366)
							)
						)
						((proc27_0 4 global303) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 9 0 0 sel_214)
							(proc27_1 4 @global303)
						)
					)
				)
				(266
					(cond 
						((or (proc0_2 161) (proc0_2 68))
							(if (proc27_0 4 global367)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 73 0 0 sel_214)
								(proc27_1 4 @global367)
							)
						)
						((proc27_0 4 global305) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 11 0 0 sel_214)
							(proc27_1 4 @global305)
						)
					)
				)
				(267
					(cond 
						((or (proc0_2 158) (proc0_2 67))
							(if (proc27_0 4 global365)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 71 0 0 sel_214)
								(proc27_1 4 @global365)
							)
						)
						((proc27_0 4 global306) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 12 0 0 sel_214)
							(proc27_1 4 @global306)
						)
					)
				)
				(269
					(cond 
						((or (proc0_2 69) (proc0_2 165) (proc0_2 166))
							(if (proc27_0 4 global365)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 70 0 0 sel_214)
								(proc27_1 4 @global365)
							)
						)
						((proc27_0 4 global308) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 14 0 0 sel_214)
							(proc27_1 4 @global308)
						)
					)
				)
				(780
					(cond 
						((or (proc0_2 155) (proc0_2 22) (gEgo sel_238: 11))
							(if (proc27_0 4 global368)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 75 0 0 sel_214)
								(proc27_1 4 @global368)
							)
						)
						((proc27_0 4 global332) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 38 0 0 sel_214)
							(proc27_1 4 @global332)
						)
					)
				)
				(else 
					(cond 
						(
						(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
						((proc27_0 4 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 4 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)
)

(instance aTut of MuseumActor
	(properties
		sel_20 {aTut}
		sel_213 1
		sel_214 1883
		sel_103 1
		sel_648 821
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (== param1 2)
			(return
				(if (not (proc0_3 111))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(super sel_300: param1)
				)
			)
		)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(switch temp0
				(258
					(cond 
						((proc0_2 134)
							(if (proc27_0 7 global364)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
								(proc27_1 7 @global364)
							)
						)
						((proc27_0 7 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
							(proc27_1 7 @global297)
						)
					)
				)
				(266
					(cond 
						((or (proc0_2 161) (proc0_2 68))
							(if (proc27_0 7 global367)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 73 0 0 sel_214)
								(proc27_1 7 @global367)
							)
						)
						((proc27_0 7 global305) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 11 0 0 sel_214)
							(proc27_1 7 @global305)
						)
					)
				)
				(else 
					(cond 
						(
						(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
						((proc27_0 7 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 7 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)
	
	(method (sel_145)
		(self sel_664:)
	)
	
	(method (sel_664 param1 param2 &tmp temp0 temp1)
		(asm
			lap      argc
			not     
			bt       code_20e6
			lap      param1
			not     
			bnt      code_216b
code_20e6:
			pToa     sel_620
			sat      temp1
code_20ea:
			lst      temp1
			pToa     sel_620
			eq?     
			bnt      code_2123
			ldi      0
			sat      temp1
			pushi    2
			pushi    1
			pushi    100
			callk    Random,  4
			sat      temp0
			lsg      global123
			ldi      3
			eq?     
			bnt      code_20ea
			lst      temp0
			ldi      5
			le?     
			bnt      code_2115
			ldi      450
			sat      temp1
			jmp      code_20ea
code_2115:
			lst      temp0
			ldi      10
			le?     
			bnt      code_20ea
			ldi      454
			sat      temp1
			jmp      code_20ea
code_2123:
			lat      temp1
			bnt      code_2151
			pTos     sel_620
			ldi      65535
			eq?     
			bnt      code_2144
			pTos     sel_652
			ldi      0
			gt?     
			bnt      code_2140
			pushi    #sel_182
			pushi    1
			pTos     sel_652
			self     6
code_2140:
			ldi      0
			aTop     sel_652
code_2144:
			pushi    #sel_664
			pushi    2
			lst      temp1
			pushSelf
			super    MuseumActor,  8
			jmp      code_2176
code_2151:
			pTos     sel_620
			ldi      65535
			ne?     
			bnt      code_215c
			pToa     sel_620
			aTop     sel_652
code_215c:
			pushi    #sel_182
			pushi    1
			pushi    65535
			self     6
			ldi      0
			aTop     sel_619
			jmp      code_2176
code_216b:
			pushi    #sel_664
			pushi    1
			lsp      param1
			&rest    param2
			super    MuseumActor,  6
code_2176:
			ret     
		)
	)
)

(instance aWatney of MuseumActor
	(properties
		sel_20 {aWatney}
		sel_213 1
		sel_214 1886
		sel_648 815
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(switch temp0
				(258
					(cond 
						((proc0_2 134)
							(if (proc27_0 8 global364)
								(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
							else
								(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
								(proc27_1 8 @global364)
							)
						)
						((proc27_0 8 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
							(proc27_1 8 @global297)
						)
					)
				)
				(else 
					(cond 
						(
						(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
						((proc27_0 8 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
						(else
							(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
							(proc27_1 8 @[global296 (- temp1 2)])
						)
					)
				)
			)
		else
			(super sel_300: param1)
		)
	)
	
	(method (sel_145)
		(self sel_664:)
	)
	
	(method (sel_664 param1 param2 &tmp temp0 temp1)
		(asm
			lap      argc
			not     
			bt       code_23cf
			lap      param1
			not     
			bnt      code_2455
code_23cf:
			pToa     sel_620
			sat      temp1
code_23d3:
			lst      temp1
			pToa     sel_620
			eq?     
			bnt      code_240c
			ldi      0
			sat      temp1
			pushi    2
			pushi    1
			pushi    100
			callk    Random,  4
			sat      temp0
			lsg      global123
			ldi      3
			eq?     
			bnt      code_23d3
			lst      temp0
			ldi      40
			le?     
			bnt      code_23fe
			ldi      500
			sat      temp1
			jmp      code_23d3
code_23fe:
			lst      temp0
			ldi      85
			le?     
			bnt      code_23d3
			ldi      530
			sat      temp1
			jmp      code_23d3
code_240c:
			lat      temp1
			bnt      code_243a
			pTos     sel_620
			ldi      65535
			eq?     
			bnt      code_242d
			pTos     sel_652
			ldi      0
			gt?     
			bnt      code_2429
			pushi    #sel_182
			pushi    1
			pTos     sel_652
			self     6
code_2429:
			ldi      0
			aTop     sel_652
code_242d:
			pushi    #sel_664
			pushi    2
			lst      temp1
			pushSelf
			super    MuseumActor,  8
			jmp      code_2460
code_243a:
			pTos     sel_620
			ldi      65535
			ne?     
			bnt      code_2446
			pToa     sel_620
			aTop     sel_652
code_2446:
			pushi    #sel_182
			pushi    1
			pushi    65535
			self     6
			ldi      0
			aTop     sel_619
			jmp      code_2460
code_2455:
			pushi    #sel_664
			pushi    1
			lsp      param1
			&rest    param2
			super    MuseumActor,  6
code_2460:
			ret     
		)
	)
)

(instance aYvette of MuseumActor
	(properties
		sel_20 {aYvette}
		sel_213 1
		sel_214 1885
		sel_103 1
		sel_648 817
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(cond 
			((== param1 2)
				(if (not (proc0_3 113))
					(gLb2Messager sel_295: sel_213 param1 80 0 0 sel_214)
				else
					(gLb2Messager sel_295: sel_213 param1 27 0 0 sel_214)
				)
			)
			((proc999_5 param1 6 14)
				(if
					(==
						(= temp0
							(if (== argc 2)
								param2
							else
								(global2 sel_422: (ScriptID 20 0))
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256 (+ temp2 1))
						(512 (+ temp2 18))
						(768 (+ temp2 26))
						(1024 (+ temp2 61))
					)
				)
				(switch temp0
					(267
						(cond 
							((or (proc0_2 158) (proc0_2 67))
								(if (proc27_0 9 global365)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 71 0 0 sel_214)
									(proc27_1 9 @global365)
								)
							)
							((proc27_0 9 global306) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 12 0 0 sel_214)
								(proc27_1 9 @global306)
							)
						)
					)
					(259
						(cond 
							((or (proc0_2 171) (proc0_2 12))
								(if (proc27_0 9 global363)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 69 0 0 sel_214)
									(proc27_1 9 @global363)
								)
							)
							((proc27_0 9 global298) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 4 0 0 sel_214)
								(proc27_1 9 @global298)
							)
						)
					)
					(258
						(cond 
							((proc0_2 134)
								(if (proc27_0 9 global364)
									(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
								else
									(gLb2Messager sel_295: sel_213 6 72 0 0 sel_214)
									(proc27_1 9 @global364)
								)
							)
							((proc27_0 9 global297) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 3 0 0 sel_214)
								(proc27_1 9 @global297)
							)
						)
					)
					(263
						(if (proc27_0 9 global302)
							(gLb2Messager sel_295: sel_213 6 1 0 0 sel_214)
						else
							(gLb2Messager sel_295: sel_213 6 24 0 0 sel_214)
							(proc27_1 9 @global302)
						)
					)
					(else 
						(cond 
							(
							(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
							((proc27_0 9 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
							(else
								(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
								(proc27_1 9 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else (super sel_300: param1))
		)
	)
)

(instance aZiggy of MuseumActor
	(properties
		sel_20 {aZiggy}
		sel_213 1
		sel_214 1890
		sel_648 816
	)
	
	(method (sel_300 param1 param2 &tmp temp0 temp1 temp2)
		(if (proc999_5 param1 6 14)
			(if
				(==
					(= temp0
						(if (== argc 2)
							param2
						else
							(global2 sel_422: (ScriptID 20 0))
						)
					)
					-1
				)
				(return)
			)
			(= temp2 (& temp0 $00ff))
			(= temp1
				(switch (& temp0 $ff00)
					(256 (+ temp2 1))
					(512 (+ temp2 18))
					(768 (+ temp2 26))
					(1024 (+ temp2 61))
				)
			)
			(cond 
				(
				(not (Message msgGET sel_214 sel_213 6 temp1 1)) (gLb2Messager sel_295: sel_213 6 81 0 0 sel_214))
				((proc27_0 11 [global296 (- temp1 2)]) (gLb2Messager sel_295: sel_213 6 1 0 0 sel_214))
				(else
					(gLb2Messager sel_295: sel_213 6 temp1 0 0 sel_214)
					(proc27_1 11 @[global296 (- temp1 2)])
				)
			)
		else
			(super sel_300: param1)
		)
	)
	
	(method (sel_145)
		(self sel_664:)
	)
	
	(method (sel_664 param1 param2 &tmp temp0 temp1)
		(asm
			lap      argc
			not     
			bt       code_296b
			lap      param1
			not     
			bnt      code_29f1
code_296b:
			pToa     sel_620
			sat      temp1
code_296f:
			lst      temp1
			pToa     sel_620
			eq?     
			bnt      code_29a8
			ldi      0
			sat      temp1
			pushi    2
			pushi    1
			pushi    100
			callk    Random,  4
			sat      temp0
			lsg      global123
			ldi      3
			eq?     
			bnt      code_296f
			lst      temp0
			ldi      5
			le?     
			bnt      code_299a
			ldi      450
			sat      temp1
			jmp      code_296f
code_299a:
			lst      temp0
			ldi      10
			le?     
			bnt      code_296f
			ldi      454
			sat      temp1
			jmp      code_296f
code_29a8:
			lat      temp1
			bnt      code_29d6
			pTos     sel_620
			ldi      65535
			eq?     
			bnt      code_29c9
			pTos     sel_652
			ldi      0
			gt?     
			bnt      code_29c5
			pushi    #sel_182
			pushi    1
			pTos     sel_652
			self     6
code_29c5:
			ldi      0
			aTop     sel_652
code_29c9:
			pushi    #sel_664
			pushi    2
			lst      temp1
			pushSelf
			super    MuseumActor,  8
			jmp      code_29fc
code_29d6:
			pTos     sel_620
			ldi      65535
			ne?     
			bnt      code_29e2
			pToa     sel_620
			aTop     sel_652
code_29e2:
			pushi    #sel_182
			pushi    1
			pushi    65535
			self     6
			ldi      0
			aTop     sel_619
			jmp      code_29fc
code_29f1:
			pushi    #sel_664
			pushi    1
			lsp      param1
			&rest    param2
			super    MuseumActor,  6
code_29fc:
			ret     
		)
	)
)

(class TravelToRoom of Script
	(properties
		sel_20 {TravelToRoom}
		sel_42 0
		sel_29 -1
		sel_134 0
		sel_135 0
		sel_136 0
		sel_137 0
		sel_138 0
		sel_139 0
		sel_140 0
		sel_141 0
		sel_142 0
		sel_143 0
		sel_65 0
		sel_665 0
		sel_666 0
	)
	
	(method (sel_111 param1)
		(if (or (not argc) (not param1)) (= sel_143 0))
		(super sel_111:)
	)
	
	(method (sel_144 theSel_29 &tmp sel_42Sel_663 temp1 museumRgnSel_643 sel_42Sel_620 sel_42Sel_654 sel_42Sel_657 sel_42Sel_660 temp7 theSel_141 theSel_141_2)
		(switch (= sel_29 theSel_29)
			(0 (= sel_141 0) (= sel_136 1))
			(1
				(if
					(and
						(==
							(= temp1 (sel_42 sel_659: (sel_42 sel_652?)))
							(sel_42 sel_620?)
						)
						(not sel_666)
					)
					(self sel_144: 9)
				else
					(if sel_666 (++ sel_29))
					(= sel_136 1)
				)
			)
			(2
				(= sel_42Sel_663 (* (sel_42 sel_663:) 11))
				(if (!= (sel_42 sel_651?) (sel_42 sel_620?))
					(= sel_141 (sel_42 sel_658: (sel_42 sel_651?)))
					(= sel_42Sel_660 (sel_42 sel_660:))
				)
				(= museumRgnSel_643
					(switch sel_42Sel_660
						(1 (MuseumRgn sel_639?))
						(2 (MuseumRgn sel_640?))
						(3 (MuseumRgn sel_641?))
						(4 (MuseumRgn sel_642?))
						(else 
							(if (== (sel_42 sel_620?) gSel_40)
								(MuseumRgn sel_643?)
							else
								0
							)
						)
					)
				)
				(switch sel_141
					(1
						(sel_42
							sel_654: (if museumRgnSel_643
								(museumRgnSel_643 sel_623?)
							else
								160
							)
							sel_655: (if museumRgnSel_643 (museumRgnSel_643 sel_624?) else 0)
						)
					)
					(2
						(sel_42
							sel_654: (if museumRgnSel_643
								(museumRgnSel_643 sel_627?)
							else
								320
							)
							sel_655: (if museumRgnSel_643 (museumRgnSel_643 sel_628?) else 95)
						)
					)
					(3
						(sel_42
							sel_654: (if museumRgnSel_643
								(museumRgnSel_643 sel_625?)
							else
								160
							)
							sel_655: (if museumRgnSel_643
								(museumRgnSel_643 sel_626?)
							else
								190
							)
						)
					)
					(4
						(sel_42
							sel_654: (if museumRgnSel_643 (museumRgnSel_643 sel_629?) else 0)
							sel_655: (if museumRgnSel_643 (museumRgnSel_643 sel_630?) else 95)
						)
					)
					(else 
						(sel_42 sel_654: 0 sel_655: 0)
					)
				)
				(if (>= (= sel_42Sel_654 (sel_42 sel_654?)) 1000)
					(sel_42 sel_654: (- sel_42Sel_654 1000))
					(= sel_665 sel_141)
				)
				(= sel_136 1)
			)
			(3
				(if sel_666
					(= sel_42Sel_620 (sel_42 sel_620?))
				else
					(= sel_42Sel_620 (sel_42 sel_661: sel_141))
				)
				(cond 
					(
						(and
							(== (sel_42 sel_620?) 530)
							(== sel_42Sel_620 600)
							(== gSel_40 530)
						)
						(= sel_139 600)
					)
					(sel_666 (= sel_136 1))
					((> (MuseumRgn sel_644: sel_42Sel_620) 1)
						(if (not (= sel_42Sel_660 (sel_42 sel_533?)))
							(-- sel_29)
							(= sel_139 15)
						else
							(sel_42 sel_533: (-- sel_42Sel_660))
							(-- sel_29)
							(= sel_139 (* (Random 3 8) 60))
						)
					)
					((== (sel_42 sel_620?) gSel_40) (= sel_139 60))
					((not (sel_42 sel_649?)) (= sel_139 (* (Random 3 15) 60)))
					(else (= sel_136 1))
				)
			)
			(4
				(if sel_666
					(= sel_136 1)
				else
					(= museumRgnSel_643
						(MuseumRgn sel_647: (sel_42 sel_620?))
					)
					(sel_42
						sel_312:
							PolyPath
							(sel_42 sel_654?)
							(sel_42 sel_655?)
							self
							1
							museumRgnSel_643
					)
				)
			)
			(5
				(if (and sel_665 (== (sel_42 sel_620?) gSel_40))
					(self sel_146: (sUseDoor sel_109:) self 1)
				else
					(= sel_136 1)
				)
			)
			(6
				(= sel_42Sel_663 (* (sel_42 sel_653?) 5))
				(if sel_666
					(sel_42
						sel_2: (if (== (sel_42 sel_620?) gSel_40)
							(sel_42 sel_648?)
						else
							828
						)
					)
					(= sel_666 0)
				else
					(= sel_42Sel_620 (sel_42 sel_661: sel_141))
					(sel_42
						sel_650: (sel_42 sel_620?)
						sel_620: sel_42Sel_620
						sel_2: (if (== sel_42Sel_620 gSel_40)
							(sel_42 sel_648?)
						else
							828
						)
						sel_663:
					)
					(MuseumRgn
						sel_644: (sel_42 sel_620?) 1
						sel_644: (sel_42 sel_650?) -1
					)
				)
				(= theSel_141 sel_141)
				(= sel_42Sel_663 (* (sel_42 sel_653?) 6))
				(if (> (sel_42 sel_650?) 0)
					(= sel_42Sel_620 (sel_42 sel_650?))
					(= sel_141 1)
					(while (< sel_141 5)
						(if
							(==
								[theTheSel_652 (+ sel_42Sel_663 sel_141 1)]
								sel_42Sel_620
							)
							(break)
						)
						(++ sel_141)
					)
				else
					(= sel_141 -1)
				)
				(= theSel_141_2 sel_141)
				(= sel_42Sel_663 (* (sel_42 sel_653?) 11))
				(cond 
					((== (sel_42 sel_620?) gSel_40) (= museumRgnSel_643 (MuseumRgn sel_643?)))
					((sel_42 sel_660:)
						(= museumRgnSel_643
							(switch theSel_141
								(1 (MuseumRgn sel_639?))
								(2 (MuseumRgn sel_640?))
								(3 (MuseumRgn sel_641?))
								(4 (MuseumRgn sel_642?))
							)
						)
					)
					(else (= museumRgnSel_643 0))
				)
				(switch theSel_141_2
					(1
						(if museumRgnSel_643
							(= sel_42Sel_654 (museumRgnSel_643 sel_623?))
							(= sel_42Sel_657 (museumRgnSel_643 sel_624?))
						else
							(= sel_42Sel_654 160)
							(= sel_42Sel_657 50)
						)
					)
					(2
						(if museumRgnSel_643
							(= sel_42Sel_654 (museumRgnSel_643 sel_627?))
							(= sel_42Sel_657 (museumRgnSel_643 sel_628?))
						else
							(= sel_42Sel_654 320)
							(= sel_42Sel_657 120)
						)
					)
					(3
						(if museumRgnSel_643
							(= sel_42Sel_654 (museumRgnSel_643 sel_625?))
							(= sel_42Sel_657 (museumRgnSel_643 sel_626?))
						else
							(= sel_42Sel_654 160)
							(= sel_42Sel_657 190)
						)
					)
					(4
						(if museumRgnSel_643
							(= sel_42Sel_654 (museumRgnSel_643 sel_629?))
							(= sel_42Sel_657 (museumRgnSel_643 sel_630?))
						else
							(= sel_42Sel_654 0)
							(= sel_42Sel_657 120)
						)
					)
					(-1
						(if museumRgnSel_643
							(= sel_42Sel_654 (museumRgnSel_643 sel_621?))
							(= sel_42Sel_657 (museumRgnSel_643 sel_622?))
						else
							(= sel_42Sel_654 160)
							(= sel_42Sel_657 165)
						)
					)
					(else 
						(= sel_42Sel_654 (= sel_42Sel_657 0))
					)
				)
				(sel_42 sel_153: sel_42Sel_654 sel_42Sel_657)
				(if (>= sel_42Sel_654 1000)
					(= sel_42Sel_654 (- sel_42Sel_654 1000))
					(= sel_665 sel_141)
				)
				(= sel_136 1)
			)
			(7
				(if (and sel_665 (== (sel_42 sel_620?) gSel_40))
					(self sel_146: (sUseDoor sel_109:) self -1)
				else
					(= sel_136 1)
				)
			)
			(8
				(if (== (sel_42 sel_656?) -1)
					(cond 
						(
							(and
								(== gSel_40 510)
								(or
									(and
										(== (sel_42 sel_650?) 520)
										(< (sel_42 sel_652?) 510)
									)
									(and
										(== (sel_42 sel_650?) 500)
										(== (sel_42 sel_652?) 520)
									)
								)
							)
							(= sel_42Sel_654 80)
							(= sel_42Sel_657 165)
						)
						((> (MuseumRgn sel_644: (sel_42 sel_620?)) 1)
							(= sel_42Sel_654
								(- ((MuseumRgn sel_643?) sel_621?) 15)
							)
							(= sel_42Sel_657
								(- ((MuseumRgn sel_643?) sel_622?) 15)
							)
						)
						((== (sel_42 sel_620?) gSel_40)
							(= sel_42Sel_654 ((MuseumRgn sel_643?) sel_621?))
							(= sel_42Sel_657 ((MuseumRgn sel_643?) sel_622?))
						)
						(else (= sel_42Sel_654 160) (= sel_42Sel_657 165))
					)
				else
					(= sel_42Sel_654 (sel_42 sel_656?))
					(= sel_42Sel_657 (sel_42 sel_657?))
				)
				(= museumRgnSel_643
					(MuseumRgn sel_647: (sel_42 sel_620?))
				)
				(sel_42
					sel_312: PolyPath sel_42Sel_654 sel_42Sel_657 self 1 museumRgnSel_643
				)
			)
			(9
				(cond 
					((!= (sel_42 sel_620?) (sel_42 sel_651?)) (= sel_141 0) (self sel_144: 2))
					((!= (sel_42 sel_652?) (sel_42 sel_651?))
						(cond 
							(
								(==
									[local0 (+ (* (= sel_42Sel_663 (sel_42 sel_663:)) 5) 1)]
									-1
								)
								(= sel_141 1)
								(sel_42
									sel_654: ((MuseumRgn sel_643?) sel_623?)
									sel_655: ((MuseumRgn sel_643?) sel_624?)
								)
							)
							((== [local0 (+ (* sel_42Sel_663 5) 2)] -1)
								(= sel_141 2)
								(sel_42
									sel_654: ((MuseumRgn sel_643?) sel_627?)
									sel_655: ((MuseumRgn sel_643?) sel_628?)
								)
							)
							((== [local0 (+ (* sel_42Sel_663 5) 3)] -1)
								(= sel_141 3)
								(sel_42
									sel_654: ((MuseumRgn sel_643?) sel_625?)
									sel_655: ((MuseumRgn sel_643?) sel_626?)
								)
							)
							((== [local0 (+ (* sel_42Sel_663 5) 4)] -1)
								(= sel_141 4)
								(sel_42
									sel_654: ((MuseumRgn sel_643?) sel_629?)
									sel_655: ((MuseumRgn sel_643?) sel_630?)
								)
							)
						)
						(= museumRgnSel_643
							(MuseumRgn sel_647: (sel_42 sel_620?))
						)
						(sel_42
							sel_312:
								PolyPath
								(sel_42 sel_654?)
								(sel_42 sel_655?)
								self
								1
								museumRgnSel_643
						)
					)
					(else (sel_42 sel_649: 0) (self sel_111: 1))
				)
			)
			(10
				(= sel_42Sel_620
					[theTheSel_652 (+ (* (= sel_42Sel_663 (sel_42 sel_653?)) 6) sel_141 1)]
				)
				(sel_42
					sel_650: (sel_42 sel_620?)
					sel_620: sel_42Sel_620
					sel_651: (sel_42 sel_652?)
					sel_663:
				)
				(MuseumRgn
					sel_644: (sel_42 sel_620?) 1
					sel_644: (sel_42 sel_650?) -1
				)
				(= sel_666 1)
				(self sel_144: 1)
			)
		)
	)
)

(instance sUseDoor of Script
	(properties
		sel_20 {sUseDoor}
	)
	
	(method (sel_144 theSel_29 &tmp temp0 temp1)
		(switch (= sel_29 theSel_29)
			(0
				(gUser sel_237: 0 sel_347: 0)
				(gGame sel_197: global21)
				(if (== sel_141 -1)
					((sel_42 sel_42?)
						sel_63: (- ((ScriptID gSel_40 (sel_42 sel_665?)) sel_60?) 1)
						sel_153:
							((ScriptID gSel_40 (sel_42 sel_665?)) sel_597?)
							((ScriptID gSel_40 (sel_42 sel_665?)) sel_598?)
					)
				)
				((ScriptID gSel_40 (sel_42 sel_665?)) sel_161: End self)
				(gListSel_109
					sel_81: ((ScriptID gSel_40 (sel_42 sel_665?)) sel_603?)
				)
			)
			(1
				(= temp0
					(if (== sel_141 1)
						((ScriptID gSel_40 (sel_42 sel_665?)) sel_597?)
					else
						((ScriptID gSel_40 (sel_42 sel_665?)) sel_303?)
					)
				)
				(= temp1
					(if (== sel_141 1)
						((ScriptID gSel_40 (sel_42 sel_665?)) sel_598?)
					else
						((ScriptID gSel_40 (sel_42 sel_665?)) sel_304?)
					)
				)
				((sel_42 sel_42?)
					sel_63: -1
					sel_312: PolyPath temp0 temp1 self
				)
			)
			(2
				((ScriptID gSel_40 (sel_42 sel_665?)) sel_161: Beg)
				(gListSel_109
					sel_118: ((ScriptID gSel_40 (sel_42 sel_665?)) sel_603?)
				)
				(sel_42 sel_665: 0)
				(gGame sel_197: ((gIconBar sel_207?) sel_33?))
				(gUser sel_237: 1 sel_347: 1)
				(self sel_111:)
			)
		)
	)
)

(instance fumeTimer of Timer
	(properties
		sel_20 {fumeTimer}
	)
	
	(method (sel_162)
		(MuseumRgn sel_135: self)
		(super sel_162: &rest)
	)
	
	(method (sel_145)
		(proc0_4 20)
	)
)

(instance meetingTimer of Timer
	(properties
		sel_20 {meetingTimer}
	)
	
	(method (sel_162 param1 param2 param3 param4 param5)
		(= global125 param5)
		(MuseumRgn sel_135: self)
		(super sel_162: param1 param2 param3 param4)
	)
	
	(method (sel_145)
		(global2 sel_403:)
		((ScriptID 22 0) sel_57: global125)
	)
)

(instance wanderTimer of Timer
	(properties
		sel_20 {wanderTimer}
	)
	
	(method (sel_145 &tmp temp0 temp1)
		(= temp0 0)
		(while (< temp0 (gSel_561 sel_86?))
			(if
				(and
					((= temp1 (gSel_561 sel_64: temp0)) sel_116: 620)
					(== (temp1 sel_620?) -1)
				)
				(temp1 sel_664:)
			)
			(++ temp0)
		)
		(self sel_162: self 120)
	)
)
